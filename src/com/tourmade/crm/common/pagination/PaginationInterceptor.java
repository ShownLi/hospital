package com.tourmade.crm.common.pagination;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.tourmade.crm.common.framework.util.BaseGlobal;


@Intercepts({ @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class,ResultHandler.class }) })
public class PaginationInterceptor implements Interceptor {

	private final static Log log = LogFactory.getLog(PaginationInterceptor.class);

	Dialect dialect = new MySql5Dialect();

	public Object intercept(Invocation invocation) throws Throwable {

		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		Integer pageIndex=new Integer(1);
		Integer pageSize=new Integer(RowBounds.NO_ROW_LIMIT);
		
		if(parameter instanceof Map){
			Map params=(Map)parameter;
			
			Object pageIndexObj=params.get(BaseGlobal.PAGINATION_PAGE_INDEX);
			Object pageSizeObj=params.get(BaseGlobal.PAGINATION_PAGE_SIZE);
			if(pageSizeObj==null || pageSizeObj==null){
				return invocation.proceed();
			}
			try{
				pageIndex=new Integer(pageIndexObj.toString());
				pageSize=new Integer(pageSizeObj.toString());
				if(pageIndex.intValue()<=0 || pageSize.intValue()<=0){
					throw new NumberFormatException("page index : "+pageIndex.intValue()+" page size : "+pageIndex.intValue());
				}
			}catch(NumberFormatException ex){
				ex.printStackTrace();
				return invocation.proceed();
			}
		}
		
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);		
		if(boundSql==null){
			return null;
		}
		String sql=boundSql.getSql().trim();
		if (sql == null || "".equals(sql)){
			return null;
		}
		RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
		
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			int offset=(pageIndex-1)*pageSize.intValue();
			rowBounds = new RowBounds( offset , pageSize.intValue());
		}

		
		String pagesql = dialect.getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());
		invocation.getArgs()[2] = new RowBounds();
		BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pagesql, boundSql.getParameterMappings(), boundSql.getParameterObject());
		MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));

		invocation.getArgs()[0] = newMs;
		
		return invocation.proceed();

	}

	public static class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties arg0) {

	}

	
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName
							.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement " + mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}

	private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
		
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.keyProperty(ms.getKeyProperty());
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.cache(ms.getCache());
		
		MappedStatement newMs = builder.build();
		
		return newMs;
	}

}