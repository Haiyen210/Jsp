package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Department;
import entity.Employee;
import utils.BkConnect;

public class ImplDepartmentDAO implements IDepartmentDAO {

	@Override
	public List<Department> selectAll() {
		Connection cnn = BkConnect.getConnection();
		String sql = "SELECT * FROM tblDepartment";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			ResultSet rs = pstt.executeQuery();
			List<Department> lst = new ArrayList<Department>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Department d = new Department(id, name);
				lst.add(d);
			}

			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Department selectById(int idDep) {
		Connection cnn = BkConnect.getConnection();
		String sql = "SELECT * FROM tblDepartment WHERE id = ?";
		try {
			PreparedStatement pstt = cnn.prepareStatement(sql);
			pstt.setInt(1, idDep);

			ResultSet rs = pstt.executeQuery();

			// Duyệt ResultSet để lấy dữ liệu
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Department dep = new Department(id, name);
				return dep;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
