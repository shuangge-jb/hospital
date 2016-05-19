package action;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userservice;

	/**
	 * @param userservice
	 *            the userservice to set
	 */
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
