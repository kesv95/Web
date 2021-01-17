package guestservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.model.GuestDAO;
import guest.model.GuestVO;
import util.PageIndex;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GuestDAO dao = GuestDAO.getInstance();
		String key = "";
		String search = "";
		String s_query = "";
		int totcount;
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.guestCount(s_query);
		}else {
			totcount = dao.guestCount();
		}
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist +1;
		}
		
		if(totcount == 0) totpage = 1;
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage>totpage) nowpage = totpage;
		
		int startpage = (nowpage-1)*maxlist +1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		List<GuestVO> list = null;
		if(key.equals("")) {
			list = dao.guestList(startpage, endpage);
		}else {
			list = dao.guestList(s_query, startpage, endpage);
		}
		
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list", "");
		}else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "guest_list", search, key);
		}
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/guest_list.jsp");
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
