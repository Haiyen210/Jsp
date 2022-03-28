package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Employee;
import utils.BkConnect;

public class ImplEmployeeDAO implements IEmployeeDAO {

	@Override
	public List<Employee> selectAll() {
		Connection cnn = BkConnect.getConnection();
		String sql = "SELECT * FROM tblEmployee";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			ResultSet rs = pstt.executeQuery();
			List<Employee> lst = new ArrayList<Employee>();

			while (rs.next()) {
				int id = rs.getInt("id");
				int iddep = rs.getInt("iddep");
				String fullname = rs.getString("fullname");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				boolean gender = rs.getBoolean("gender");
				double salary = rs.getDouble("salary");
				boolean status = rs.getBoolean("status");
				String imglink = rs.getString("imglink");

				Employee e = new Employee(id, iddep, fullname, address, birthday, gender, salary, status, imglink);
				lst.add(e);
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean insert(Employee emp) {
		Connection cnn = BkConnect.getConnection();
		String sql = "INSERT INTO tblEmployee VALUES (?, ?, ?, ?, ?, ?, ?,'')";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			pstt.setInt(1, emp.getIddep());
			pstt.setString(2, emp.getFullname());
			pstt.setString(3, emp.getAddress());
			pstt.setDate(4, new java.sql.Date(emp.getBirthday().getTime()));
			pstt.setBoolean(5, emp.isGender());
			pstt.setDouble(6, emp.getSalary());
			pstt.setBoolean(7, emp.isStatus());

			boolean isOk = pstt.executeUpdate() > 0;

			return isOk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee detail(int idEmp) {
		Connection cnn = BkConnect.getConnection();
		String sql = "SELECT * FROM tblEmployee WHERE id = ?";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			pstt.setInt(1, idEmp);

			ResultSet rs = pstt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int iddep = rs.getInt("iddep");
				String fullname = rs.getString("fullname");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				boolean gender = rs.getBoolean("gender");
				double salary = rs.getDouble("salary");
				boolean status = rs.getBoolean("status");
				String imglink = rs.getString("imglink");

				Employee e = new Employee(id, iddep, fullname, address, birthday, gender, salary, status, imglink);
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Employee emp) {
		Connection cnn = BkConnect.getConnection();
		String sql = "UPDATE tblEmployee SET" + "iddep = ?," + "fullname = ?," + "address = ?,"
				+ "	birthday = ?," + "gender = ?," + "salary = ?," + "status = ?,"
				+ "	imglink = ?" + "WHERE id = ?";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			pstt.setInt(1, emp.getIddep());
			pstt.setString(2, emp.getFullname());
			pstt.setString(3, emp.getAddress());
			pstt.setDate(4, new java.sql.Date(emp.getBirthday().getTime()));
			pstt.setBoolean(5, emp.isGender());
			pstt.setDouble(6, emp.getSalary());
			pstt.setBoolean(7, emp.isStatus());
			pstt.setString(8, emp.getImglink());
			pstt.setInt(9, emp.getId());

			boolean isOk = pstt.executeUpdate() > 0;

			return isOk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(int idEmp) {
		Connection cnn = BkConnect.getConnection();
		String sql = "DELETE FROM tblEmployee WHERE id = ?";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			pstt.setInt(1, idEmp);			

			boolean isOk = pstt.executeUpdate() > 0;
			return isOk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> search(int depId, String data) {
		Connection cnn = BkConnect.getConnection();
		String sql = "SELECT * FROM tblEmployee WHERE iddep = ? AND (fullname LIKE ? OR address LIKE ?)";
		if (depId == 0) {
			sql = "SELECT * FROM tblEmployee WHERE (fullname LIKE ? OR address LIKE ?)";
		}
		
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			// Cài đặt tham số
			if (depId != 0) {
				pstt.setInt(1, depId);
				pstt.setString(2, "%" + data + "%");
				pstt.setString(3, "%" + data + "%");
			} else {				
				pstt.setString(1, "%" + data + "%");
				pstt.setString(2, "%" + data + "%");
			}			

			ResultSet rs = pstt.executeQuery();
			List<Employee> lst = new ArrayList<Employee>();

			// Duyệt ResultSet để lấy dữ liệu
			while (rs.next()) {
				int id = rs.getInt("id");
				int iddep = rs.getInt("iddep");
				String fullname = rs.getString("fullname");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				boolean gender = rs.getBoolean("gender");
				double salary = rs.getDouble("salary");
				boolean status = rs.getBoolean("status");
				String imglink = rs.getString("imglink");

				Employee e = new Employee(id, iddep, fullname, address, birthday, gender, salary, status, imglink);
				lst.add(e);
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
