package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import persistance.Department;
import service.DepartmentService;

import com.opensymphony.xwork2.ActionSupport;

import dao.DepartmentDao;

public class DepartmentAction extends ActionSupport {
	private DepartmentService departmentService ;
	private HttpServletRequest request;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param departmentService the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute() 查询所有的科别，返回JSON字符串
	 */
	@Override
	public String execute() throws Exception {
		HttpSession session=request.getSession();	
		String hospitalName=(String) session.getAttribute("hospital");
		List<String>departments=departmentService.getDepartmentNamesInHospital(hospitalName);
		//TODO
		//打包成JSON
		
		return null;
	}

}
