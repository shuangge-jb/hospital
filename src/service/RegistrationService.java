package service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import dao.RegistrationDao;

public class RegistrationService {
	private RegistrationDao registrationDao;

	/**
	 * @param registrationDao
	 *            the registrationDao to set
	 */
	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	/**
	 * 先对前端传来的时间段作转换，然后查询数据库，得到挂号信息
	 * 
	 * @param doctorName
	 * @param periods
	 * @return
	 */
	public JSONArray findRegistrations(String doctorName, String periods) {
		String date=periods.substring(0,10);
		String firstPeriodBegin = periods.contains("上午")?"09:00:00":"14:00:00";
		String lastPeriodBegin = periods.contains("上午")?"11:00:00":"16:00:00";
		List<Map<String, String>> list = registrationDao.findRegistrations(
				doctorName,date, firstPeriodBegin, lastPeriodBegin);

		if (list.size() > 0) {
			for (Map<String, String> item : list) {
				String registrationDesc = item.get("id") + " "
						+ item.get("userName") + " " + item.get("doctorName");

				System.out.println(registrationDesc);
			}
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray = JSONArray.fromObject(list);

		return jsonArray;
	}
	/**
	 * 更改用户的就诊状态  e.g. 已就诊
	 * @param userId
	 * @return
	 */
	public int mark(String userId){
		return registrationDao.mark(userId);
	}
	
}
