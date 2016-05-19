package com.tourmade.crm.common.framework.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tourmade.crm.common.framework.BaseBean;
import com.tourmade.crm.common.framework.BaseDao;
import com.tourmade.crm.common.framework.PageList;
import com.tourmade.crm.common.framework.exception.TransactionException;

public class MybatisDaoImpl<T extends BaseBean<T>> implements BaseDao<T> {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private String namespace;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public MybatisDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
			this.namespace = entityClass.getAnnotation(HLJWMapperPackage.class).value();
		}
	}

	public int insert(T t) {
		String method = namespace + ".insert";
		return this.sqlSession.insert(method, t);
	}

	public int update(T t) {
		String method = namespace + ".update";
		return this.sqlSession.update(method, t);
	}

	public int deleteById(String id) {
		String method = namespace + ".deleteById";
		return this.sqlSession.delete(method, id);
	}

	public int updateNotNullValue(T t) {
		String method = namespace + ".updateNotNullValue";
		return this.sqlSession.update(method, t);
	}

	/**
	 * ���ʵ����Ϣɾ�����
	 * 
	 * @param baseBean
	 * @return
	 */
	public int delete(T t) {
		String method = namespace + ".delete";
		return this.sqlSession.delete(method, t);
	}

	/**
	 * ���ʵ��bean��ѯ������ݵļ���
	 * 
	 * @param baseBean
	 *            ��ѯʵ��bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> select(T t) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pojo", t);
		String method = namespace + ".list";
//		return (List<T>) this.sqlSession.selectList(method, params);
		return null;
	}

	/**
	 * ���ʵ��bean��ѯ������ݵļ���
	 * 
	 * @param baseBean
	 *            ��ѯʵ��bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> select(T t, String... fields) {

		Map<String, Object> params = new HashMap<String, Object>();
		String columns = Arrays.toString(fields);

		params.put("pojo", t);
		params.put("columns", columns.substring(1, columns.length() - 1));

		String method = namespace + ".list";
//		return (List<T>) this.sqlSession.selectList(method, params);
		return null;
	}

	/**
	 * ���ʵ���ѯ��ʵ�������б�
	 * 
	 * @param baseBean
	 *            ʵ��bean
	 * @param curPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ÿҳ��ʾ������
	 * @return
	 * @throws TransactionException
	 */
	@SuppressWarnings("unchecked")
	public PageList<T> select(T t, int curPage, int pageSize) throws TransactionException {
		Map<String, Object> params = new HashMap<String, Object>();

		String method = namespace + ".selectPageSize";

		params.put("pojo", t);	
		params.put(BaseGlobal.PAGINATION_PAGE_INDEX, curPage);
		params.put(BaseGlobal.PAGINATION_PAGE_SIZE, pageSize);

		PageList<T> pageList = new PageList<T>();
		pageList.setCurPage(curPage);
		pageList.setPageSize(pageSize);
		pageList.setCount(-1);
//		List<T> listData = (List<T>) this.sqlSession.selectList(method, params);
//		pageList.setListData(listData);
		return pageList;
	}

	/**
	 * ���ʵ���ѯ��ʵ�������б�
	 * 
	 * @param baseBean
	 *            ʵ��bean
	 * @param curPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ÿҳ��ʾ������
	 * @param fields
	 *            Ҫ��ʾ����
	 * @return
	 * @throws TransactionException
	 */
	@SuppressWarnings("unchecked")
	public PageList<T> select(T t, int curPage, int pageSize, String... fields) throws TransactionException {
		Map<String, Object> params = new HashMap<String, Object>();

		String method = namespace + ".selectPageSize";
		String columns = Arrays.toString(fields);

		params.put("pojo", t);
		params.put("columns", columns.substring(1, columns.length() - 1));
		params.put(BaseGlobal.PAGINATION_PAGE_INDEX, curPage);
		params.put(BaseGlobal.PAGINATION_PAGE_SIZE, pageSize);

		PageList<T> pageList = new PageList<T>();
		pageList.setCurPage(curPage);
		pageList.setPageSize(pageSize);
		pageList.setCount(-1);
//		List<T> listData = (List<T>) this.sqlSession.selectList(method, params);
//		pageList.setListData(listData);

		return pageList;
	}


	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@SuppressWarnings("unchecked")
	public T findById(String id) {
		String method = namespace + ".findById";
		this.sqlSession.selectOne(method, id);
		return (T) this.sqlSession.selectOne(method, id);
	}

	@Override
	public long count(T t) throws TransactionException {
		// TODO Auto-generated method stub
		return 0;
	}

}
