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
		JSONArray jsonArray = scheduleService.findPeriods(getValue("doctorName"));
		return save(jsonArray);
	}

	/**
	 * �����ݿ��ȡ�Һ���Ϣ
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
	 * ����û��ѿ������������ݿ�
	 * 
	 * @return
	 */
	public String mark() {
		String userId = getValue("userId");
		save(JSONArray.fromObject(registrationService.mark(userId)));
		return SUCCESS;
	}

	/**
	 * ��ȡ���������
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
	 * �����ݴ���ǰ��
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
			writer.close();// һ��Ҫ�رգ�������׳��쳣
		} catch (IOException e) {

			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
