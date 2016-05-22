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
	 * �ȶ�ǰ�˴�����ʱ�����ת����Ȼ���ѯ���ݿ⣬�õ��Һ���Ϣ
	 * 
	 * @param doctorName
	 * @param periods
	 * @return
	 */
	public JSONArray findRegistrations(String doctorName, String periods) {
		String date=periods.substring(0,10);
		String firstPeriodBegin = periods.contains("����")?"09:00:00":"14:00:00";
		String lastPeriodBegin = periods.contains("����")?"11:00:00":"16:00:00";
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
	 * �����û��ľ���״̬  e.g. �Ѿ���
	 * @param userId
	 * @return
	 */
	public int mark(String userId){
		return registrationDao.mark(userId);
	}
	
}
