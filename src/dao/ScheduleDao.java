package dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Doctor;
import persistance.Period;
import persistance.Schedule;
import persistance.ScheduleId;
import persistance.WorkTime;
import persistance.WorkTimeId;

/**
 * 处理Schedule表的相关操作
 * 
 * @author Administrator
 *
 */
public class ScheduleDao extends HibernateDaoSupport {

	public ScheduleDao() {
		super();

	}

	
	public List<Period> findPeriods(String doctorName) {
		String sql = null;
		sql = "select p.* from doctor d join schedule s join period p "
				+ "where  s.doctor_id=d.doctor_id and s.period_id=p.period_id and d.name= :doctorName";
		@SuppressWarnings("unchecked")
		List<Period> list = getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity("p", Period.class)
				.setString("doctorName", doctorName).list();
		System.out.println("list size: " + list.size());
		return list;
	}

	/**
	 * 找出相应的对象 如果找不到，返回null
	 * 
	 * @param doctorId
	 * @param date
	 * @param firstPeriodBegin
	 * @param lastPeriodBegin
	 * @return
	 */
	public Schedule find(String doctorId, String date, String firstPeriodBegin,
			String lastPeriodBegin) {
		String sql = "select w.doctor_id,w.period_id "
				+ " from schedule w join period p   "
				+ "where w.period_id=p.period_id and w.doctor_id=:doctorId and p.date=:date "
				+ " and p.begin_time>=:firstPeriodBegin and p.begin_time<=:lastPeriodBegin";
		Query query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql)
				.addEntity("w", Schedule.class)
				.setString("doctorId", doctorId).setString("date", date)
				.setString("firstPeriodBegin", firstPeriodBegin)
				.setString("lastPeriodBegin", lastPeriodBegin);
		@SuppressWarnings("unchecked")
		List<Schedule> list = query.list();
		return list.size() > 0 ? (Schedule) list.get(0) : null;
	}
	
	public boolean save(Doctor doctor, Period period) {
		ScheduleId scheduleId = new ScheduleId();
		scheduleId.setDoctorId(doctor.getDoctorId());
		scheduleId.setPeriodId(period.getPeriodId());
		Schedule schedule = new Schedule();
		schedule.setId(scheduleId);
		schedule.setDoctor(doctor);
		schedule.setPeriod(period);
		this.getSessionFactory().getCurrentSession().save(schedule);
		return false;
	}
	@Deprecated
	public boolean delete(String doctorId, String date, String beginTime,
			String endTime) {
		String sql="select period_id from period p where where p.date=:date "
			+ "and p.begin_time=:beginTime and p.end_time=:endTime";
		Query query=this.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity("p",Period.class).setString("date", date)
				.setString("beginTime", beginTime).setString("endTime", endTime);
		Period period=(Period) query.list().get(0);
		sql = "delete from schedule w where w.doctor_id=:doctorId and w.period_id=:periodId ";
		this.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity("w",WorkTime.class)
				.setString("doctorId", doctorId)
				.setString("periodId", String.valueOf(period.getPeriodId())).executeUpdate();
		return true;
	}
	
	
}
