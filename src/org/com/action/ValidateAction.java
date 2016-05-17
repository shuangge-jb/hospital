package org.com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ValidateAction extends ActionSupport implements ServletRequestAware{
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
		
		return INVALID;
	}

}
