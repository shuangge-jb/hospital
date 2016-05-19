package action;

import service.HospitalService;

import com.opensymphony.xwork2.ActionSupport;

public class HospitalAction extends ActionSupport {
private HospitalService hospitalService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param hospitalService the hospitalService to set
	 */
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}

}
