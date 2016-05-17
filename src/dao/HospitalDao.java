package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import persistance.Hospital;

/**
 * ����Hospital�����ز���
 * 
 * @author Administrator
 *
 */
public class HospitalDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Hospital> findAll() {
		return getHibernateTemplate().find("from hospital");
	}
}
