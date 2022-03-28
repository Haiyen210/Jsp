package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDAO {
	public List<Employee> selectAll();

	public boolean insert(Employee emp);

	public Employee detail(int idEmp);

	public boolean update(Employee emp);

	public boolean delete(int idEmp);
	public List<Employee> search(int depId, String data);
}
