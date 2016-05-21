package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import persistance.Doctor;
import persistance.Period;
import persistance.Schedule;
import dao.ScheduleDao;

public class ScheduleDaoTest {

	@Test
	public void testFindPeriods() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory();
		String sql = null;
		sql = "select p.* from doctor d join schedule s join period p "
				+ "where  s.doctor_id=d.id and s.period_id=p.id and d.id= :doctorId";
		Session session = sessionFactory.openSession();
		List<Period> list = session
				.createSQLQuery(sql).addEntity("p", Period.class)
				.setString("doctorId", "1").list();
		System.out.println("list size: " + list.size());
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
		System.out.println(jsonArray.toString());
		sessionFactory.close();
	}

}
