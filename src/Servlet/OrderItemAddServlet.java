package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.OrderItem;
import Dao.OrderItemDao;

/**
 * Servlet implementation class OrderItemAddServlet
 */
@WebServlet("/OrderItemAddServlet")
public class OrderItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user_id");
		if(user==null||user.equals("")){
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("请先登录", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
			return ;
		}
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int num = Integer.parseInt(request.getParameter("number"));
		List<OrderItem> L = new OrderItemDao().listOrderItem();
		boolean flag = false;
		for(OrderItem oi:L){
			if(oi.getProduct().getId()==product_id&&oi.getUser_id()==user_id){
				new OrderItemDao().updateOrderItem(product_id, oi.getNumber()+num, user_id);
				flag = true;
				break;
			}
		}
		if(flag==false){
			new OrderItemDao().addOrderItem(product_id, num, user_id);
		}
		
		response.sendRedirect("listOrderItem?user_id="+user_id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
