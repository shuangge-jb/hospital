package service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import persistance.Period;
import persistance.Registration;
import dao.ScheduleDao;

public class ScheduleService {
	private ScheduleDao scheduleDao;

	/**
	 * @param scheduleDao
	 *            the scheduleDao to set
	 */
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
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
				String timeDesc = transformPeriod(item.getDate(),
						item.getBeginTime());
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
	private String transformPeriod(Date date, Time time) {
		long morningBeginHour = Time.valueOf("09:00:00").getTime();
		long morningEndHour = Time.valueOf("11:00:00").getTime();
		String timeDesc = null;
		long hour = time.getTime();
		if (hour >= morningBeginHour && hour <= morningEndHour) {
			timeDesc = date.toString().substring(0, 10) + " 上午";
		} else {
			timeDesc = date.toString().substring(0, 10) + " 下午";
		}
		return timeDesc;
	}
}
