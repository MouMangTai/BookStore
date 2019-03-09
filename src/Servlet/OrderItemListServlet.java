package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.OrderItem;
import Bean.Product;
import Dao.OrderItemDao;
import Dao.ProductDao;

/**
 * Servlet implementation class OrderItemListServlet
 */
@WebServlet("/OrderItemListServlet")
public class OrderItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		List<OrderItem> L= new OrderItemDao().getOrderItem(user_id);
		
		request.getSession().setAttribute("ois",L);
		response.sendRedirect("cartList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
