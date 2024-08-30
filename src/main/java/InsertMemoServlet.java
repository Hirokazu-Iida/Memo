

import java.io.IOException;

import bean.MemoBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MemoDAO;

/**
 * Servlet implementation class InsertMemoServlet
 */
public class InsertMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemoServlet() {
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
		
		HttpSession session = request.getSession(false);
		
		String memoTitle = request.getParameter("memoTitle");
		String memoContent = request.getParameter("memoContent");
		String memoUserId = (String) session.getAttribute("loginId");
		
		System.out.println("insertMemo セッションあり " + memoUserId + memoTitle + memoContent);
		
		MemoBean mb = new MemoBean();
		mb.setMemoTitle(memoTitle);
		mb.setMemoContent(memoContent);
		mb.setMemoUserId(memoUserId);
		
		System.out.println("mb 通過 ok!");
		
		MemoDAO md = new MemoDAO();
		md.insertMemo(mb);
		
		System.out.println("insert ok!");
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
		
	}

}
