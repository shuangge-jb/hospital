package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.User;
/**
 * ����User�����ز���
 * @author Administrator
 *
 */
public class UserDao extends HibernateDaoSupport{
@SuppressWarnings("unchecked")
public List<User> findAll() {
		return getHibernateTemplate().find("from User");
	}
}
