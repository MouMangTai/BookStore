package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Product;
import Bean.Type;
import Dao.ProductDao;
import Dao.TypeDao;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = 0;
		int count = 12;
		
		try{
			start = Integer.parseInt(request.getParameter("start"));
		}catch(NumberFormatException e){
			
		}

		int pre = start-count;
		int next = start+count;
		int total = new ProductDao().getTotal();
		int end =0;
		if(total%count==0){
			end = total-count;
		}else{
			end = total - total%count;
		}
		if(pre<0) pre=0;
		if(next>end) next = end;
		String typeid = request.getParameter("typeId");
		List<Product> L = null;
		if(typeid==null||typeid.equals("")) {
			L = new ProductDao().listProduct(start,count);
		}
		else {
			L = new ProductDao().listProductByTypeId(start,count,Integer.parseInt(typeid));
		}
		request.setAttribute("products", L);
		List<Type> T = new TypeDao().listType();
		request.setAttribute("types", T);
		request.setAttribute("pre", pre);
		request.setAttribute("next", next);
		request.setAttribute("end", end);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
