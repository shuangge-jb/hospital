package dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Department;
import persistance.Doctor;
import persistance.User;

/**
 * 处理Doctor表的相关操作
 * 
 * @author Administrator
 *
 */
public class DoctorDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return getHibernateTemplate().find("from Doctor");
	}

	public void save(Map<String, String> map) {
		Doctor doctor = new Doctor();
		doctor.setAge(Integer.parseInt(map.get("age")));
		doctor.setSex(map.get("sex"));
		DepartmentDao departmentDao = new DepartmentDao();
		Department department = departmentDao.find(map.get("department"));

		doctor.setDepartment(department);
		HospitalDao hospitalDao = new HospitalDao();

		doctor.setHospital(hospitalDao.find(map.get("hospital")));
		doctor.setName(map.get("doctorName"));
		doctor.setTel(map.get("tel"));

		getHibernateTemplate().save(doctor);
	}

}
