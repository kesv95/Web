package exDay1229_.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exDay1229_.model.GuestDAO;
import exDay1229_.model.GuestDTO;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		GuestDAO dao = GuestDAO.getInstance();
		
		
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("GuestList"+idx)) {
				bool = true;
				break;
			}
		}
		int row = 0;
		String newValue = "" + System.currentTimeMillis();
		if(!bool) {
			info = new Cookie("GuestList"+idx,newValue);
			info.setMaxAge(24*60*60);
			response.addCookie(info);
			row = dao.guestReadCount(idx);
		}
		GuestDTO vo = dao.guestView(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
	
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
