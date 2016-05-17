package service;

import dao.DoctorDao;

public class DoctorService {
	private DoctorDao doctorDao;

	/**
	 * @param doctorDao
	 *            the doctorDao to set
	 */
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

}
