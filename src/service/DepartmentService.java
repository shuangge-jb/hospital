package service;

import java.util.List;

import dao.DepartmentDao;

/**
 * 定义业务逻辑
 * 
 * @author Administrator
 *
 */
public class DepartmentService {
	private DepartmentDao departmentDao;

	/**
	 * @param departmentDao
	 *            the departmentDao to set
	 */
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public List<String> getDepartmentsInHospital(String hospitalName) {
		//TODO
		return null;

	}
}
