package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import service.DoctorService;
import com.opensymphony.xwork2.ActionSupport;

public class DoctorValidateAction extends ActionSupport implements
		ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private DoctorService doctorService;
	private static final String VALID = "valid";
	private static final String INVALID = "invalid";

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		boolean isExisted = doctorService.isExisted(userName);
		return isExisted == false ? VALID : INVALID;
	}

}
