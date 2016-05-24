package dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Department;
import persistance.Doctor;

/**
 * 处理Doctor表的相关操作
 * 
 * @author Administrator
 *
 */
public class DoctorDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Doctor> findAll() {
		return getHibernateTemplate().find("from Doctor");
	}

	@SuppressWarnings("unchecked")
	public Doctor findByName(String doctorName) {
		String sql = "select d.* from doctor d where d.name=:doctorName";
		List<Doctor> doctor = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity("d", Doctor.class)
				.setString("doctorName", doctorName).list();
		return doctor.size() > 0 ? doctor.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public Doctor findById(String doctorId) {
		String sql = "select d.* from doctor d where d.id=:doctorId";
		System.out.println("DoctorDao: " + this.getSessionFactory());
		List<Doctor> list = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity("d", Doctor.class)
				.setString("doctorId", doctorId).list();
		System.out.println("doctor list size: " + list.size());
		return list.size() > 0 ? list.get(0) : null;
	}

	

}
