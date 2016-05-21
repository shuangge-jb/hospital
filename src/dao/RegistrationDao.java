package dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 处理Registratoion表的相关操作
 * 
 * @author Administrator
 *
 */
public class RegistrationDao extends HibernateDaoSupport {
	public List<Map<String, String>> findRegistrations(String doctorName) {
		String sql = null;
		sql = " select r.id id,u.user_name userName ,p.begin_time beginTime "
				+ " from registration r join doctor do join department de join user u join period p "
				+ " where r.doctor_id=do.id and r.department_id = de.id and r.user_id=u.user_id and r.period_id=p.id"
				+ " and do.name=:doctorName ";
		@SuppressWarnings("unchecked")
		Query query = getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addScalar("id", Hibernate.STRING)
				.addScalar("userName", Hibernate.STRING)
				.addScalar("beginTime", Hibernate.STRING)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.setString("doctorName", doctorName);

		return query.list();
	}
}
