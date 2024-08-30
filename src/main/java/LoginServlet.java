

import java.io.IOException;
import java.util.List;

import bean.AccountBean;
import bean.MemoBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginDAO;
import model.MemoDAO;

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
			session.setAttribute("loginId",returnAb.getLoginId());
			session.setAttribute("userName", returnAb.getLoginUserName());
			
			MemoDAO md = new MemoDAO();
			List<MemoBean> returnLmb = md.showList(loginId);
			System.out.println("showListメソッド通過");
			
			session.setAttribute("returnLmb", returnLmb);
			session = request.getSession(false);		
			
			if (session == null) {
				System.out.println("セッションなし");
				request.getRequestDispatcher("/login.html").forward(request, response);
				return;
			}else {
				String Li = (String) session.getAttribute("loginId");
				System.out.println("セッションあり " + Li);
			}
			
//			request.setAttribute("userName", returnAb.getLoginUserName());
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
