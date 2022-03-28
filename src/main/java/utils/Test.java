package utils;

import java.util.List;

import dao.IEmployeeDAO;
import dao.ImplEmployeeDAO;
import entity.Employee;

public class Test {

	public static void main(String[] args) {
		IEmployeeDAO empDao = new ImplEmployeeDAO();
		List<Employee> lstEmp = empDao.selectAll();
		for (Employee e : lstEmp) {
			System.out.println(e.getFullname());
		}
	}

}
