package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.OrderItemDao;

/**
 * Servlet implementation class OrderItemDeleteServlet
 */
@WebServlet("/OrderItemDeleteServlet")
public class OrderItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		new OrderItemDao().deleteOrderItem(product_id,  user_id);
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
