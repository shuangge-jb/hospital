package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.User;
/**
 * 处理Doctor表的相关操作
 * @author Administrator
 *
 */
public class DoctorDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
			return getHibernateTemplate().find("from Doctor");
		}
}
