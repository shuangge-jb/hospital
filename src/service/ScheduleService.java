package service;

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

}
