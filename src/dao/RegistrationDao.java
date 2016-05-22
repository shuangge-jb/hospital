package dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class RegistrationDao extends HibernateDaoSupport {
	private static final String HANDLED = "已就诊";

	/**
	 * 
	 * @param doctorName
	 * @param firstPeriodBegin
	 *            当天上/下午第一个时间段的开始时间. e.g. 09:00:00
	 * @param lastPeriodBegin
	 *            当天上/下午最后一个时间段的开始时间. e.g. 11:00:00
	 * @return
	 */
	public List<Map<String, String>> findRegistrations(String doctorName,
			String date, String firstPeriodBegin, String lastPeriodEnd) {
		String sql = null;
		sql = " select r.id id,u.user_name userName ,p.begin_time beginTime"
				+ " from registration r join doctor do join department de join user u join period p "
				+ " where "
				+ "r.doctor_id=do.id and r.department_id = de.id and r.user_id=u.user_id and r.period_id=p.id  and "
				+ " do.name=:doctorName and p.date=:date and "
				+ " p.begin_time>=:firstPeriodBegin and p.begin_time<=:lastPeriodBegin";
		@SuppressWarnings("unchecked")
		Query query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addScalar("id", Hibernate.STRING)
				.addScalar("userName", Hibernate.STRING)
				.addScalar("beginTime", Hibernate.STRING)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.setString("doctorName", "爽哥").setString("date", date)
				.setString("firstPeriodBegin", firstPeriodBegin)
				.setString("lastPeriodBegin", lastPeriodEnd);

		return query.list();
	}

	/**
	 * 更改用户的就诊状态 e.g. 已就诊
	 * 
	 * @param userId
	 * @return
	 */
	public int mark(String userId) {
		String sql = "update registration set state=:handled where user_id=:userId ";
		int result = getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).setString("handled", HANDLED)
				.setString("userId", userId).executeUpdate();
		return result;
	}
}
