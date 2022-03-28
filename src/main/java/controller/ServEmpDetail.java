package controller;

import java.io.IOException;
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
 * Servlet implementation class ServEmpDetail
 */
@WebServlet("/employee-detail")
public class ServEmpDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServEmpDetail() {
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

		if (strIdEmp != null && !strIdEmp.isEmpty()) {
			IEmployeeDAO empDao = new ImplEmployeeDAO();
			Employee emp = empDao.detail(Integer.parseInt(strIdEmp));

			IDepartmentDAO depDao = new ImplDepartmentDAO();
			Department dep = depDao.selectById(emp.getIddep());
			
			request.setAttribute("emp", emp);
			request.setAttribute("dep", dep);
			request.getRequestDispatcher("emp-detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("employee-list");
		}

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
