package service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import persistance.Period;
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

	public JSONArray findPeriods(String doctorName) {
		List<Period> list = scheduleDao.findPeriods(doctorName);
		List<String> periodNames = new ArrayList<String>(list.size());
		if (list.size() > 0) {
			for (Period item : list) {
				String timeDesc = item.getDate().toString().substring(0, 10)
						+ " " + item.getBeginTime().toString();
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
}
