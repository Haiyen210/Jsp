package dao;

import java.util.List;

import entity.Department;

public interface IDepartmentDAO {
	public List<Department> selectAll();

	public Department selectById(int idDep);
}
