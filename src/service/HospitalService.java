package service;

import dao.HospitalDao;

public class HospitalService {
	private HospitalDao hospitalDao;

	/**
	 * @param hospitalDao
	 *            the hospitalDao to set
	 */
	public void setHospitalDao(HospitalDao hospitalDao) {
		this.hospitalDao = hospitalDao;
	}

}
