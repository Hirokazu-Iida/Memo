

import java.io.IOException;
import java.util.List;

import bean.MemoBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MemoDAO;

/**
 * Servlet implementation class DeleteMemoServlet
 */
public class DeleteMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemoServlet() {
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
		
		String deleteId = request.getParameter("deleteId");
		HttpSession session = request.getSession(false);
		String loginId = (String) session.getAttribute("loginId");
		
		MemoBean mb = new MemoBean();
		mb.setMemoUserId(deleteId);
		
		MemoDAO md =new MemoDAO();
		md.deleteMemo(deleteId);
		
		// 一覧再取得
		List<MemoBean> returnLmb = md.showList(loginId);
		System.out.println("showListメソッド通過");
		session.setAttribute("returnLmb", returnLmb);
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
