package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Department;

/**
 * ����Department�����ز���
 * 
 * @author Administrator
 *
 */
public class DepartmentDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		return getHibernateTemplate().find("from department");
	}
}
