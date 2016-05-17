package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistance.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao;

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
/**
 * 判断用户是否存在
 * @param userName
 * @return
 */
	public boolean isExisted(String userName) {
		List<User> users=userDao.findAll();
		Set<String>userNames=new HashSet<String>();
		for(User item:users){
			userNames.add(item.getUserName());
		}
		return userNames.contains(userName);

	}
}
