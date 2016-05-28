package service;



import org.apache.log4j.Logger;

import com.mysql.jdbc.log.Log;

import persistance.Doctor;
import persistance.Period;
import persistance.WorkTime;
import dao.DoctorDao;
import dao.PeriodDao;
import dao.WorkTimeDao;
@Deprecated
public class WorkTimeService {
	private WorkTimeDao workTimeDao;
	private DoctorDao doctorDao;
	private PeriodDao periodDao;
	private static final String EXISTED = "�Ѵ���";
	private static final String SUCCESS = "����ɹ�";
	private static final String ERROR = "����ʧ��";
	private static final int NUM_PERIODS=3;

	public WorkTimeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the workTimeDao
	 */
	public WorkTimeDao getWorkTimeDao() {
		return workTimeDao;
	}

	/**
	 * @param workTimeDao
	 *            the workTimeDao to set
	 */
	public void setWorkTimeDao(WorkTimeDao workTimeDao) {
		this.workTimeDao = workTimeDao;
	}

	/**
	 * @return the doctorDao
	 */
	public DoctorDao getDoctorDao() {
		return doctorDao;
	}

	/**
	 * @param doctorDao
	 *            the doctorDao to set
	 */
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	/**
	 * @return the periodDao
	 */
	public PeriodDao getPeriodDao() {
		return periodDao;
	}

	/**
	 * @param periodDao
	 *            the periodDao to set
	 */
	public void setPeriodDao(PeriodDao periodDao) {
		this.periodDao = periodDao;
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

		workTimeDao.save(doctor, period);
		return true;
	}

	public boolean delete(String doctorId, String periods) {
		String date = periods.substring(0, 10);
		if (periods.contains("����")) {
			workTimeDao.delete(doctorId, date, "09:00:00", "10:00:00");
			workTimeDao.delete(doctorId, date, "10:00:00", "11:00:00");
			workTimeDao.delete(doctorId, date, "11:00:00", "12:00:00");
		} else {
			workTimeDao.delete(doctorId, date, "14:00:00", "15:00:00");
			workTimeDao.delete(doctorId, date, "15:00:00", "16:00:00");
			workTimeDao.delete(doctorId, date, "16:00:00", "17:00:00");
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
		WorkTime workTime = workTimeDao.find(doctorId, date, firstPeriodBegin,
				lastPeriodBegin);
		Logger.getLogger(WorkTimeService.class).info("workTime : "+workTime);
		return workTime != null;
	}

}
