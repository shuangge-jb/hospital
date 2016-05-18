package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistance.User;
import dao.DoctorDao;

public class DoctorService {
	private DoctorDao doctorDao;

	/**
	 * @param doctorDao
	 *            the doctorDao to set
	 */
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}
	/**
	 * 判断医生是否存在
	 * @param userName
	 * @return
	 */
		public boolean isExisted(String userName) {
			List<User> users=doctorDao.findAll();
			Set<String>userNames=new HashSet<String>();
			for(User item:users){
				userNames.add(item.getUserName());
			}
			return userNames.contains(userName);

		}
}
