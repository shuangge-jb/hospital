package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import service.ScheduleService;
import service.WorkTimeService;

import com.opensymphony.xwork2.ActionSupport;

public class SelectTimeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkTimeService workTimeService;
	
	public SelectTimeAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param workTimeService
	 *            the workTimeService to set
	 */
	public void setWorkTimeService(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}

	/**
	 * ��ǰ�˴��������ݱ��浽���ݿ���
	 * 
	 * @return
	 */
	public String insert() {
		String doctorId = getValue("doctorId");
		String periods = getValue("periods");
		String result = workTimeService.save(doctorId, periods);
		Logger.getLogger(SelectTimeAction.class).info("result: "+result);
		return save(JSONArray.fromObject(new ArrayList<String>(1).add(result)));
	}

	/**
	 * ɾ��ָ��������
	 * 
	 * @return
	 */
	public String delete() {
		String doctorId = getValue("doctorId");
		String periods = getValue("periods");
		boolean result = workTimeService.delete(doctorId, periods);
		String resultStr = result == true ? SUCCESS : ERROR;
		return save(JSONArray.fromObject(resultStr));
		
	}

	/**
	 * ��ȡ���������
	 * 
	 * @param attribute
	 * @return
	 */
	private String getValue(String attribute) {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("attribute: " + attribute + "  value: "
				+ request.getParameter(attribute));
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
