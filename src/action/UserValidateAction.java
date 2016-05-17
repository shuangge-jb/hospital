package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserValidateAction extends ActionSupport implements
		ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private UserService userService;
	private static final String VALID = "valid";
	private static final String INVALID = "invalid";
	private static final String ISEXISTED = "existed";

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
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		boolean isExisted = userService.isExisted(userName);
		return isExisted == false ? VALID : INVALID;
	}

}
