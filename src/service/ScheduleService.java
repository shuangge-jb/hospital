package service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import persistance.Doctor;
import persistance.Period;
import persistance.Registration;
import persistance.Schedule;
import persistance.WorkTime;
import dao.DoctorDao;
import dao.PeriodDao;
import dao.RegistrationDao;
import dao.ScheduleDao;

public class ScheduleService {
	private ScheduleDao scheduleDao;
	private RegistrationDao registrationDao;
	private DoctorDao doctorDao;
	private PeriodDao periodDao;
	private static final String EXISTED = "已存在";
	private static final String SUCCESS = "插入成功";
	private static final String ERROR = "插入失败";
	private static final int NUM_PERIODS=3;
	private static final String MORNING="-上午";
	private static final String AFTERNOON="-下午";
	private static final String FILLED="filled";
	private static final String UNFILLED="unfilled";
	private static final int NUM_REGISTRATION_PRE_PERIOD=6;
	/**
	 * @param scheduleDao
	 *            the scheduleDao to set
	 */
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	/**
	 * @param registrationDao the registrationDao to set
	 */
	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	/**
	 * @param doctorDao the doctorDao to set
	 */
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	/**
	 * @param periodDao the periodDao to set
	 */
	public void setPeriodDao(PeriodDao periodDao) {
		this.periodDao = periodDao;
	}

	/**
	 * 从数据库取出时间段，转化成前端的格式，打包成JSON
	 * 
	 * @param doctorName
	 * @return
	 */
	public JSONArray findPeriods(String doctorName) {
		List<Period> list = scheduleDao.findPeriods(doctorName);
		Set<String> periodNames = new HashSet<String>(list.size());
		if (list.size() > 0) {
			for (Period item : list) {
				String timeDesc = transformPeriod(doctorName,item);
				periodNames.add(timeDesc);
				System.out.println(timeDesc);
			}
		}
		JSONArray jsonArray = new JSONArray();
		if (periodNames.size() > 0) {
			jsonArray = JSONArray.fromObject(periodNames);
		}
		return jsonArray;
	}

	/**
	 * 将数据库取出的时间格式转化成前端显示的时间格式
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	
	private String transformPeriod(String doctorName,Period period) {
		Date date=period.getDate();
		Time time=period.getBeginTime();
		long morningBeginHour = Time.valueOf("09:00:00").getTime();
		long morningEndHour = Time.valueOf("11:00:00").getTime();
		String timeDesc = null;
		long hour = time.getTime();
		String mornOrAfter=null;
		if (hour >= morningBeginHour && hour <= morningEndHour) {
			mornOrAfter= MORNING;
		} else {
			mornOrAfter=AFTERNOON;
		}
		String isFilled=isFilled(doctorName,period)?FILLED:UNFILLED;
		timeDesc = date.toString().substring(0, 10) +mornOrAfter+"-"+isFilled;
		return timeDesc;
	}
	
	public String save(String doctorId, String periods) {
		boolean isExisted = isExisted(doctorId, periods);
		if (isExisted == true) {
			return EXISTED;
		}
		int counter = 0;// 记录插入成功的数量
		boolean isSuccess = false;
		String date = periods.substring(0, 10);
		if (periods.contains("上午")) {
			isSuccess = save(doctorId, date, "09:00:00", "10:00:00");
			counter += isSuccess ? 1 : 0;
			isSuccess = save(doctorId, date, "10:00:00", "11:00:00");
			counter += isSuccess ? 1 : 0;
			isSuccess = save(doctorId, date, "11:00:00", "12:00:00");
			counter += isSuccess ? 1 : 0;
		} else {
			isSuccess = save(doctorId, date, "14:00:00", "15:00:00");
			counter += isSuccess ? 1 : 0;
			isSuccess = save(doctorId, date, "15:00:00", "16:00:00");
			counter += isSuccess ? 1 : 0;
			isSuccess = save(doctorId, date, "16:00:00", "17:00:00");
			counter += isSuccess ? 1 : 0;
		}
		return counter == NUM_PERIODS ? SUCCESS : ERROR;
	}

	public List<String> getWorkTime(String doctorName){
		List<Period> periods=scheduleDao.findPeriods(doctorName);
		List<String>result=new ArrayList<String>(periods.size());
		for(Period item:periods){
			result.add(transformPeriod(doctorName,item));
		}
		return result;
	}
	private boolean save(String doctorId, String date, String beginTime,
			String endTime) {
		System.out.println("doctorId: " + doctorId);
		Doctor doctor = doctorDao.findById(doctorId);// 不可能为空
		Period period = periodDao.find(date, beginTime, endTime);
		if (period == null) {
			periodDao.save(date, beginTime, endTime);
			period = periodDao.find(date, beginTime, endTime);
		}
		scheduleDao.save(doctor, period);
		return true;
	}

	@Deprecated
	public boolean delete(String doctorId, String periods) {
		String date = periods.substring(0, 10);
		if (periods.contains("上午")) {
			scheduleDao.delete(doctorId, date, "09:00:00", "10:00:00");
			scheduleDao.delete(doctorId, date, "10:00:00", "11:00:00");
			scheduleDao.delete(doctorId, date, "11:00:00", "12:00:00");
		} else {
			scheduleDao.delete(doctorId, date, "14:00:00", "15:00:00");
			scheduleDao.delete(doctorId, date, "15:00:00", "16:00:00");
			scheduleDao.delete(doctorId, date, "16:00:00", "17:00:00");
		}
		return true;
	}

	/**
	 * 判断该时间段是否存在
	 * 
	 * @param doctorId
	 * @param periods
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isExisted(String doctorId, String periods) {
		String date = periods.substring(0, 10);
		String firstPeriodBegin = periods.contains("上午") ? "09:00:00"
				: "14:00:00";
		String lastPeriodBegin = periods.contains("上午") ? "11:00:00"
				: "16:00:00";
		Schedule schedule = scheduleDao.find(doctorId, date, firstPeriodBegin,
				lastPeriodBegin);
		Logger.getLogger(ScheduleService.class).info("workTime : "+schedule);
		return schedule != null;
	}
	/**
	 * 判断该时间段是否已满
	 * 每个时间段最多看5个病人
	 * @param doctorName
	 * @param period
	 * @return
	 */
	private boolean isFilled(String doctorName,Period period){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date=period.getDate();  
		String dateStr=sdf.format(date);  
		String time=period.getBeginTime().toString();
		List<Registration>list=registrationDao.find(doctorName, dateStr, time);
		return list.size()>=NUM_REGISTRATION_PRE_PERIOD;
	}
}
