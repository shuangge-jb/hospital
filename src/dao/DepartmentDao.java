package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Department;

/**
 * 处理Department表的相关操作
 * 
 * @author Administrator
 *
 */
public class DepartmentDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		return getHibernateTemplate().find("from department");
	}

	@SuppressWarnings("unchecked")
	public List<Department> findDepartmentsByName(String str) {
		return getHibernateTemplate()
				.find("from department where name= " + str);
	}

	public Department find(String str) {
		List<Department> departments = findDepartmentsByName(str);
		Department department = null;
		for (Department item : departments) {
			if (item.getName().equals(str)) {
				department = item;
				break;
			}
		}
		return department;

	}
	
}
