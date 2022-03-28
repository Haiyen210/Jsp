package controller;

import java.io.IOException;
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
 * Servlet implementation class ManagementEmployee
 */
@WebServlet("/")
public class ManagementEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagementEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Load dữ liệu từ database
				IEmployeeDAO empDao = new ImplEmployeeDAO();
				List<Employee> lstEmp = empDao.selectAll();

				// Đẩy lên request
				request.setAttribute("lstEmp", lstEmp);
				
				// Dữ liệu phòng ban
				IDepartmentDAO depDAO = new ImplDepartmentDAO();
				List<Department> lstDep = depDAO.selectAll();
				request.setAttribute("lstDep", lstDep);		

				// Chuyển tới trang JSP
				request.getRequestDispatcher("quanlynv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
