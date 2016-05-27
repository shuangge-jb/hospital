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
import persistance.WorkTime;
import dao.DoctorDao;
import dao.PeriodDao;
import dao.ScheduleDao;

public class ScheduleService {
	private ScheduleDao scheduleDao;
	private DoctorDao doctorDao;
	private PeriodDao periodDao;
	private static final String EXISTED = "�Ѵ���";
	private static final String SUCCESS = "����ɹ�";
	private static final String ERROR = "����ʧ��";
	private static final int NUM_PERIODS=3;
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
	
	public String save(String doctorId, String periods) {
		boolean isExisted = isExisted(doctorId, periods);
		if (isExisted == true) {
			return EXISTED;
		}
		int counter = 0;// ��¼����ɹ�������
		boolean isSuccess = false;
		String date = periods.substring(0, 10);
		if (periods.contains("����")) {
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

	private boolean save(String doctorId, String date, String beginTime,
			String endTime) {
		System.out.println("doctorId: " + doctorId);
		Doctor doctor = doctorDao.findById(doctorId);// ������Ϊ��
		Period period = periodDao.find(date, beginTime, endTime);
		if (period == null) {
			periodDao.save(date, beginTime, endTime);
			period = periodDao.find(date, beginTime, endTime);
		}

		scheduleDao.save(doctor, period);
		return true;
	}

	public boolean delete(String doctorId, String periods) {
		String date = periods.substring(0, 10);
		if (periods.contains("����")) {
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
	 * �жϸ�ʱ����Ƿ����
	 * 
	 * @param doctorId
	 * @param periods
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isExisted(String doctorId, String periods) {
		String date = periods.substring(0, 10);
		String firstPeriodBegin = periods.contains("����") ? "09:00:00"
				: "14:00:00";
		String lastPeriodBegin = periods.contains("����") ? "11:00:00"
				: "16:00:00";
		WorkTime workTime = scheduleDao.find(doctorId, date, firstPeriodBegin,
				lastPeriodBegin);
		Logger.getLogger(WorkTimeService.class).info("workTime : "+workTime);
		return workTime != null;
	}
}
