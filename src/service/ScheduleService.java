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
	 * �����ݿ�ȡ��ʱ��Σ�ת����ǰ�˵ĸ�ʽ�������JSON
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
	 * �����ݿ�ȡ����ʱ���ʽת����ǰ����ʾ��ʱ���ʽ
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
			timeDesc = date.toString().substring(0, 10) + " ����";
		} else {
			timeDesc = date.toString().substring(0, 10) + " ����";
		}
		return timeDesc;
	}
}
