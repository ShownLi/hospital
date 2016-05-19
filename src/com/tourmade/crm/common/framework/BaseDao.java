package com.tourmade.crm.common.framework;

import java.util.List;

import com.tourmade.crm.common.framework.exception.TransactionException;

public interface BaseDao<T extends BaseBean<T>> {

	/**
	 * 数据新增
	 * 
	 * @param t
	 * @return
	 */
	public int insert(T t);

	/**
	 * 数据修改
	 * 
	 * @param t
	 * @return
	 */
	public int update(T t);

	/**
	 * 数据修改(值不为空的数据)
	 * 
	 * @param t
	 * @return
	 */
	public int updateNotNullValue(T t);

	/**
	 * 根据ID删除数据
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	public int deleteById(String id);

	/**
	 * 根据实体信息删除数据
	 * 
	 * @param baseBean
	 * @return
	 */
	public int delete(T t);

	/**
	 * 根据实体bean查询所有数据的集合
	 * 
	 * @param baseBean
	 *            查询实体bean
	 * @return
	 */
	public List<T> select(T t);

	/**
	 * 根据实体bean查询所有数据的集合
	 * 
	 * @param baseBean
	 *            查询实体bean
	 * @param fields
	 *            查询的字段名
	 * @return
	 */
	public List<T> select(T t, String... fields);

	/**
	 * 根据实体查询该实体的数据列表
	 * 
	 * @param baseBean
	 *            实体bean
	 * @param curPage
	 *            当前页
	 * @param pageSize
	 *            每页显示的条数
	 * @return
	 * @throws TransactionException
	 */
	public PageList<T> select(T t, int curPage, int pageSize)
			throws TransactionException;

	/**
	 * 根据实体查询该实体的数据列表
	 * 
	 * @param t
	 *            实体bean
	 * @param curPage
	 *            当前页
	 * @param pageSize
	 *            每页显示的条数
	 * @param fields
	 *            查询的字段名
	 * @return
	 * @throws TransactionException
	 */
	public PageList<T> select(T t, int curPage, int pageSize, String... fields)
			throws TransactionException;

	/**
	 * 根据ID查询对象
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id);

	/**
	 * 根据实体查询该实体的数据列表
	 * 
	 * @param baseBean
	 *            实体查询bean
	 * @return
	 * @throws TransactionException
	 */
	public long count(T t) throws TransactionException;

}
