package action;

import java.util.List;

import persistance.Department;

import com.opensymphony.xwork2.ActionSupport;

import dao.DepartmentDao;

public class FindDepartmentsAction extends ActionSupport {
	private DepartmentDao departmentDao = new DepartmentDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute() ��ѯ���еĿƱ𣬷���JSON�ַ���
	 */
	@Override
	public String execute() throws Exception {
		// TODO
		@SuppressWarnings("unchecked")
		List<Department> list = (List<Department>) departmentDao.findAll();
		StringBuffer sb = new StringBuffer();
		for (Department item : list) {

			sb.append(item.getType());
		}
		return null;
	}

}
