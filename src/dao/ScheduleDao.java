package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Period;

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

	
}
