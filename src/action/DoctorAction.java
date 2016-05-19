package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.json.annotations.JSON;

import service.DoctorService;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DoctorAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private DoctorService doctorService;
	private Map<String,String>doctorInfo;
	private String isExisted = UNEXISTED;
	
	private static final String EXISTED = "existed";
	private static final String UNEXISTED = "unexisted";

	

	/**
	 * @return the doctorInfo
	 */
	public Map<String, String> getDoctorInfo() {
		return doctorInfo;
	}

	/**
	 * @param doctorInfo the doctorInfo to set
	 */
	public void setDoctorInfo(Map<String, String> doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

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

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the doctorService
	 */
	public DoctorService getDoctorService() {
		return doctorService;
	}

	/**
	 * @return the isExisted
	 */
	@JSON(name = "isExisted")
	public String getIsExisted() {
		return isExisted;
	}

	public String isNameExisted() {
		
		String doctorName = request.getParameter("doctorName");
		doctorInfo.put("doctorName", doctorName);
		System.out.println("doctorName: " + doctorName);
		
		isExisted = EXISTED;
		return SUCCESS;
	}
	public String save(){
		String doctorName = request.getParameter("doctorName");
		doctorInfo.put("doctorName", doctorName);
		System.out.println("doctorName: " + doctorName);
		String sex=request.getParameter("sex");
		doctorInfo.put("sex", sex);
		System.out.println("sex: " + sex);
		String age=request.getParameter("age");
		doctorInfo.put("age", age);
		System.out.println("age: " + age);
		String department=request.getParameter("department");
		doctorInfo.put("department", department);
		System.out.println("department: " + department);
		String hospital=request.getParameter("hospital");
		doctorInfo.put("hospital", hospital);
		System.out.println("hospital: " + hospital);
		String tel=request.getParameter("tel");
		doctorInfo.put("tel", tel);
		System.out.println("tel: " + tel);
		doctorService.save(doctorInfo);
		return SUCCESS;
	}
}
