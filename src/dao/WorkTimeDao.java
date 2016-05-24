package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Doctor;
import persistance.Period;
import persistance.WorkTime;
import persistance.WorkTimeId;

public class WorkTimeDao extends HibernateDaoSupport {
	/**
	 * 找出相应的对象 如果找不到，返回null
	 * 
	 * @param doctorId
	 * @param date
	 * @param firstPeriodBegin
	 * @param lastPeriodBegin
	 * @return
	 */
	public WorkTime find(String doctorId, String date, String firstPeriodBegin,
			String lastPeriodBegin) {
		String sql = "select w.doctor_id,w.period_id "
				+ " from worktime w join period p   "
				+ "where w.period_id=p.id and w.doctor_id=:doctorId and p.date=:date "
				+ " and p.begin_time>=:firstPeriodBegin and p.begin_time<=:lastPeriodBegin";
		Query query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql)
				.addEntity("w", WorkTime.class)
				.setString("doctorId", doctorId).setString("date", date)
				.setString("firstPeriodBegin", firstPeriodBegin)
				.setString("lastPeriodBegin", lastPeriodBegin);
		@SuppressWarnings("unchecked")
		List<WorkTime> list = query.list();
		return list.size() > 0 ? (WorkTime) list.get(0) : null;
	}

	public boolean save(Doctor doctor, Period period) {
		WorkTimeId workTimeId = new WorkTimeId();
		workTimeId.setDoctorId(doctor.getId());
		workTimeId.setPeriodId(period.getId());
		WorkTime workTime = new WorkTime();
		workTime.setId(workTimeId);
		workTime.setDoctor(doctor);
		workTime.setPeriod(period);
		this.getSessionFactory().getCurrentSession().save(workTime);
		return false;
	}

	public boolean delete(String doctorId, String date, String beginTime,
			String endTime) {
		String sql="select id from period p where where p.date=:date "
			+ "and p.begin_time=:beginTime and p.end_time=:endTime";
		Query query=this.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity("p",Period.class).setString("date", date)
				.setString("beginTime", beginTime).setString("endTime", endTime);
		Period period=(Period) query.list().get(0);
		sql = "delete from worktime w where w.doctor_id=:doctorId and w.period_id=:periodId ";
		this.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity("w",WorkTime.class)
				.setString("doctorId", doctorId)
				.setString("periodId", String.valueOf(period.getId())).executeUpdate();
		return true;
	}
}
