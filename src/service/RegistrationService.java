package service;

import dao.RegistrationDao;

public class RegistrationService {
	private RegistrationDao registrationDao;

	/**
	 * @param registrationDao
	 *            the registrationDao to set
	 */
	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

}
