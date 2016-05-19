package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Department;
import persistance.Hospital;

/**
 * 处理Hospital表的相关操作
 * 
 * @author Administrator
 *
 */
public class HospitalDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Hospital> findAll() {
		return getHibernateTemplate().find("from hospital");
	}

	@SuppressWarnings("unchecked")
	public List<Department> findDepartmentsOfHospital(String hospitalName) {
		return getHibernateTemplate()
				.find("select Department from Department left outer join Hospital on "
						+ "Department.hospital.id = Hospital.id where Hospital.name= "
						+ hospitalName);
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> findHospitalsByName(String hospitalName) {
		return getHibernateTemplate().find(
				"from hospital where name= " + hospitalName);
	}

	public Hospital find(String hospitalName) {
		List<Hospital> hospitals = findHospitalsByName(hospitalName);
		Hospital hospital = null;
		for (Hospital item : hospitals) {
			if (item.getName().equals(hospitalName)) {
				hospital = item;
				break;
			}
		}
		return hospital;
	}
}
