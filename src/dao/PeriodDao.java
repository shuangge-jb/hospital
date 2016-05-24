package dao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Period;

/**
 * 处理Period表的相关操作
 * 
 * @author Administrator
 *
 */
public class PeriodDao extends HibernateDaoSupport {
	/**
	 * 查找相应的医生，如果找不到，返回null
	 * 
	 * @param date
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public Period find(String date, String beginTime, String endTime) {
		Query query = this
				.getSessionFactory()
				.getCurrentSession()
				.createSQLQuery(
						"select * from period p "
								+ " where p.date=:date and p.begin_time=:beginTime and p.end_time=:endTime ")
				.addEntity("p", Period.class).setString("date", date)
				.setString("beginTime", beginTime)
				.setString("endTime", endTime);
		@SuppressWarnings("unchecked")
		List<Period> list = query.list();
		return list.size() == 0 ? null : list.get(0);
	}

	public boolean save(String date, String beginTime, String endTime) {
		Period period = new Period();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			period.setBeginTime(new Time(simpleDateFormat.parse(date+" "+beginTime)
					.getTime()));
			period.setDate(simpleDateFormat.parse(date+" "+beginTime));
			period.setEndTime(new Time(simpleDateFormat.parse(date+" "+endTime)
					.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		this.getSessionFactory().getCurrentSession().save(period);
		return true;
	}
}
