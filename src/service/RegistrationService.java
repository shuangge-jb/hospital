package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import persistance.Registration;
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
	public JSONArray findRegistrations(String doctorName) {
		List<Map<String, String>> list = registrationDao.findRegistrations(doctorName);
		
		if (list.size() > 0) {
			for (Map<String, String> item : list) {
				String registrationDesc = item.get("id") + " "
						+ item.get("userName") + " "
						+ item.get("doctorName");
				
				System.out.println(registrationDesc);
			}
			
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray = JSONArray.fromObject(list);
		
			
		
		return jsonArray;
	}
}
