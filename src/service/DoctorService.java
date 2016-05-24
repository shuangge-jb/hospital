package service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import persistance.Doctor;
import persistance.User;
import dao.DepartmentDao;
import dao.DoctorDao;
import dao.HospitalDao;

public class DoctorService {
	private DoctorDao doctorDao;
	private DepartmentDao departmentDao;
	private HospitalDao hospitalDao;

	/**
	 * @param doctorDao
	 *            the doctorDao to set
	 */
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	/**
	 * @return the departmentDao
	 */
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	/**
	 * @param departmentDao
	 *            the departmentDao to set
	 */
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	/**
	 * @return the hospitalDao
	 */
	public HospitalDao getHospitalDao() {
		return hospitalDao;
	}

	/**
	 * @param hospitalDao
	 *            the hospitalDao to set
	 */
	public void setHospitalDao(HospitalDao hospitalDao) {
		this.hospitalDao = hospitalDao;
	}

	/**
	 * @return the doctorDao
	 */
	public DoctorDao getDoctorDao() {
		return doctorDao;
	}

	

	
}
