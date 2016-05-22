package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.junit.Test;

public class RegistrationDaoTest {

	@Test
	public void testFindRegistrations() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = null;
		sql = " select r.id id,u.user_name userName ,p.begin_time beginTime,de.name departmentName,do.name doctorName"
				+ " from registration r join doctor do join department de join user u join period p "
				+ " where "
				+ "r.doctor_id=do.id and r.department_id = de.id and r.user_id=u.user_id and r.period_id=p.id  and "
				+ " do.id=:doctorName ";
		@SuppressWarnings("unchecked")
		Query query = session.createSQLQuery(sql)
				.addScalar("id", Hibernate.STRING)
				.addScalar("userName", Hibernate.STRING)
				.addScalar("beginTime", Hibernate.STRING)
				.addScalar("departmentName", Hibernate.STRING)
				.addScalar("doctorName", Hibernate.STRING)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.setString("doctorName", "1");
		List<Map<String, String>> list = query.list();
		System.out.println("list size: " + list.size());
		for (Map<String, String> item : list) {
			System.out.println("id: " + item.get("id"));
			System.out.println("userName: " + item.get("userName"));
			System.out.println("beginTime: " + item.get("beginTime"));
			System.out.println("departmentName: " + item.get("departmentName"));
			System.out.println("doctorName: " + item.get("doctorName"));
		}

	}

}
