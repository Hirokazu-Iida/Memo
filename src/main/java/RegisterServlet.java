

import java.io.IOException;

import bean.AccountBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		String userName = request.getParameter("userName");
		
		AccountBean ab = new AccountBean();
		ab.setLoginId(loginId);
		ab.setLoginPass(loginPass);
		ab.setLoginUserName(userName);
		
		RegisterDAO rdo= new RegisterDAO();
		rdo.registerAccount(ab);
		
		RequestDispatcher rd = request.getRequestDispatcher("/registerSuccess.jsp");
		rd.forward(request, response);
	}

}
