package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.User;
/**
 * ����Doctor�����ز���
 * @author Administrator
 *
 */
public class DoctorDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
			return getHibernateTemplate().find("from Doctor");
		}
}
