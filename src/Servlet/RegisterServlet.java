package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.User;
import Dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		request.getSession().setAttribute("LastRegisterMail", mail);
		request.getSession().setAttribute("LastRegisterWord", password);
		request.getSession().setAttribute("LastRegisterName", name);
		if(!mail.matches("^[0-9a-z_]+@(([0-9a-z]+)[.]){1,2}[a-z]{2,3}$")){
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("请输入正确的邮箱地址", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Register.jsp'</script>");
			return ;
		}
		if(!password.matches("(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}")){
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("密码过于简单", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Register.jsp'</script>");
			return ;
		}
		/*if(!name.matches("^[a-zA-Z0-9_-]{4,16}$")){
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("用户名不符合命名规定", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Register.jsp'</script>");
			return ;
		}*/
		User u = new UserDao().getUser(mail);
		if(u==null){
			new UserDao().addUser(mail, password, name);
			request.getSession().setAttribute("LastLoginMail", mail);
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("注册成功", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
		}else{
			PrintWriter out = response.getWriter();
			String a = URLEncoder.encode("该邮箱已被注册", "UTF-8"); 
			out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Register.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
