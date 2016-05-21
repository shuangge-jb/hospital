package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
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

	private DoctorService doctorService;
	private RegistrationService registrationService;
	private ScheduleService scheduleService;

	/**
	 * @param doctorService
	 *            the doctorService to set
	 */
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

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
		
		 Logger logger = Logger.getLogger(this.getClass()); 
		HttpSession session = ServletActionContext.getRequest().getSession();
		//从session获得当前登录doctor信息
		String doctorName = (String) session.getAttribute("doctorName");
		
		if(doctorName==null){
			doctorName="null";
		}
		try {
			doctorName=URLDecoder.decode(doctorName,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		String doctorName="爽哥";
		System.out.println("HandleAction doctorName: " + doctorName);
		JSONArray jsonArray=scheduleService.findPeriods(doctorName);
		HttpServletResponse response =ServletActionContext.getResponse();
		 response.setCharacterEncoding("UTF-8");   
		 
			try {
				PrintWriter writer=response.getWriter();
				writer.print(jsonArray.toString());
				writer.close();//一定要关闭，否则会抛出异常
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.getMessage());
				
			}
		 
		return SUCCESS;
	}
}
