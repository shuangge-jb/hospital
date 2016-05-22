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
	 * 查找该医生的所有上班时间段
	 * 
	 * @return
	 */
	public String getPeriods() {
		// String doctorName="爽哥";
		JSONArray jsonArray = scheduleService.findPeriods(getValue("doctorName"));
		return save(jsonArray);
	}

	/**
	 * 从数据库获取挂号信息
	 * 
	 * @return
	 */
	public String getRegistrations() {
		String doctorName = getValue("doctorName");
		String receivePeriods = getValue("periods");
		JSONArray jsonArray = null;
		if (receivePeriods != null) {
			jsonArray = registrationService.findRegistrations(doctorName,
					receivePeriods);
		}
		return save(jsonArray);
	}

	/**
	 * 标记用户已看病，更改数据库
	 * 
	 * @return
	 */
	public String mark() {
		String userId = getValue("userId");
		save(JSONArray.fromObject(registrationService.mark(userId)));
		return SUCCESS;
	}

	/**
	 * 获取请求的数据
	 * 
	 * @param attribute
	 * @return
	 */
	private String getValue(String attribute) {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter(attribute));
		return request.getParameter(attribute);
	}

	/**
	 * 将数据传到前端
	 * 
	 * @param jsonArray
	 * @return
	 */
	private String save(JSONArray jsonArray) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.print(jsonArray);
			writer.close();// 一定要关闭，否则会抛出异常
		} catch (IOException e) {

			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
