

import java.io.IOException;

import bean.AccountBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String userName = null;
		
		AccountBean ab = new AccountBean();
		ab.setLoginId(loginId);
		ab.setLoginPass(loginPass);
		ab.setLoginUserName(userName);
		
		LoginDAO ld =new LoginDAO();
		AccountBean returnAb = ld.findAccount(ab);
		
		HttpSession session = request.getSession(false);
		
		if(returnAb!=null) {
			
			session = request.getSession(true);
			String sun = request.getParameter("userName");
			session.setAttribute("userName",sun);
			
			// HOME servlet　を作る？
//			if (session == null) {
//			      request.getRequestDispatcher("Login").forward(request, response);
//			      return;
//			 }
            
			request.setAttribute("userName", returnAb.getLoginUserName());
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
