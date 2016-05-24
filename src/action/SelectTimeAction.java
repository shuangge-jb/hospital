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
	 * 将前端传来的数据保存到数据库中
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
	 * 删除指定的数据
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
	 * 获取请求的数据
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
