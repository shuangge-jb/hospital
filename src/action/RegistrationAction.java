package action;

import service.DoctorService;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction extends ActionSupport {
	private DoctorService doctorService;

	/**
	 * @param doctorService
	 *            the doctorService to set
	 */
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

}
