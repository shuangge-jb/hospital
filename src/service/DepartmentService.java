package service;

import java.util.List;


import dao.DepartmentDao;

/**
 * ����ҵ���߼�
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

	public List<String> getDepartmentNamesInHospital(String hospitalName) {
		//TODO
		departmentDao.find(hospitalName);
		return null;
	}
	
}
