package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserValidateAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private static final String VALID="valid";
	private static final String INVALID="invalid";
	private static final String ISEXISTED="existed";
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		HttpSession session=request.getSession();	
		String userName=(String) session.getAttribute("userName");
		
		return INVALID;
	}

}
