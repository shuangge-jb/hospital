package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.User;
/**
 * 处理User表的相关操作
 * @author Administrator
 *
 */
public class UserDao extends HibernateDaoSupport{
@SuppressWarnings("unchecked")
public List<User> findAll() {
		return getHibernateTemplate().find("from User");
	}
}
