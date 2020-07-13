package Servlet;

import java.io.IOException;
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
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String jiage = request.getParameter("jiage");
		String kucun = request.getParameter("kucun");
		String beizhu = request.getParameter("beizhu");
		String tupian = request.getParameter("tupian");
		String type = request.getParameter("type");
		double jiage_  = Double.parseDouble(jiage);
		int kucun_ = Integer.parseInt(kucun);
		Product p = new Product();
		p.setName(name);
		p.setValue(jiage_);
		p.setLeft_number(kucun_);
		p.setMessage(beizhu);
		p.setImage_src(tupian);
		Type t = new TypeDao().getType(Integer.parseInt(type));
		p.setType(t);
		new ProductDao().addProduct(p);
		response.sendRedirect("listProduct");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
