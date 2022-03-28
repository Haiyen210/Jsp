package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDepartmentDAO;
import dao.IEmployeeDAO;
import dao.ImplDepartmentDAO;
import dao.ImplEmployeeDAO;
import entity.Department;
import entity.Employee;

/**
 * Servlet implementation class ServEmpUpdate
 */
@WebServlet("/employee-update")
public class ServEmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServEmpUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String strIdEmp = request.getParameter("idEmp");
		if (strIdEmp == null) {
			response.sendRedirect("employee-list");
		} else {
			int idEmp = Integer.parseInt(strIdEmp);
			IEmployeeDAO empDao = new ImplEmployeeDAO();
			Employee emp = empDao.detail(idEmp);

			IDepartmentDAO depDao = new ImplDepartmentDAO();
			List<Department> lstDep = depDao.selectAll();
			Department dep = depDao.selectById(emp.getIddep());

			request.setAttribute("emp", emp);
			request.setAttribute("lstDep", lstDep);
			request.setAttribute("dep", dep);
			request.getRequestDispatcher("emp-update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int idEmp = Integer.parseInt(request.getParameter("txtId"));
		int iddep = Integer.parseInt(request.getParameter("optDeparment"));
		String fullname = request.getParameter("txtFullname");
		String address = request.getParameter("txtAddress");
		Date birthday = fmtDate(request.getParameter("txtBirthday"));
		boolean gender = request.getParameter("radGender").equals("1") ? true : false;
		double salary = Double.parseDouble(request.getParameter("txtSalary"));
		boolean status = request.getParameter("chkStatus") != null ? true : false;
		String imglink = "";

		Employee emp = new Employee(idEmp, iddep, fullname, address, birthday, gender, salary, status, imglink);
		IEmployeeDAO empDao = new ImplEmployeeDAO();
		boolean isOk = empDao.update(emp);

		if (isOk) {
			request.setAttribute("msgOk", "Cập nhật  thành công");
		} else {
			request.setAttribute("msgErr", "Cập thật thất bại");
		}

		request.setAttribute("emp", emp);
		response.sendRedirect("/Demo/");
	}

	private Date fmtDate(String strDate) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
