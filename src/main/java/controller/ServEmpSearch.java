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
 * Servlet implementation class ServEmpSearch
 */
@WebServlet("/employee-search")
public class ServEmpSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServEmpSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// Dữ liệu search
		int depId = Integer.parseInt(request.getParameter("optDepartment"));
		String strSearch = request.getParameter("txtSearch");

		// Truy vấn bằng DAO
		IEmployeeDAO empDAO = new ImplEmployeeDAO();
		List<Employee> lstEmp;

		// Tình huống dữ liệu search rỗng
//		if (strSearch == null || strSearch.isEmpty()) {
//			lstEmp = empDAO.selectAll();
//		} else {
			lstEmp = empDAO.search(depId, strSearch);
//		}

		// Đẩy lên request
		request.setAttribute("lstEmp", lstEmp);

		// Dữ liệu phòng ban
		IDepartmentDAO depDAO = new ImplDepartmentDAO();
		List<Department> lstDep = depDAO.selectAll();
		request.setAttribute("lstDep", lstDep);

		request.getRequestDispatcher("quanlynv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
