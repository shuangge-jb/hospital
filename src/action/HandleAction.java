package action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.DoctorService;
import service.RegistrationService;
import service.ScheduleService;

import com.opensymphony.xwork2.ActionSupport;

public class HandleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private RegistrationService registrationService;
	private ScheduleService scheduleService;

	

	/**
	 * @param registrationService
	 *            the registrationService to set
	 */
	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	/**
	 * @param scheduleService
	 *            the scheduleService to set
	 */
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	/**
	 * ���Ҹ�ҽ���������ϰ�ʱ���
	 * 
	 * @return
	 */
	public String getPeriods() {
		// String doctorName="ˬ��";
		JSONArray jsonArray = scheduleService.findPeriods(getDoctorName());
		return save(jsonArray);
	}

	public String getRegistrations() {
		JSONArray jsonArray = registrationService
				.findRegistrations(getDoctorName());
		return save(jsonArray);
	}

	private String getDoctorName() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��session��õ�ǰ��¼doctor��Ϣ
		return request.getParameter("doctorName");
	}

	private String save(JSONArray jsonArray) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.print(jsonArray.toString());
			writer.close();// һ��Ҫ�رգ�������׳��쳣
		} catch (IOException e) {

			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
