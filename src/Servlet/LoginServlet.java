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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String[] isadmin = request.getParameterValues("checkadmin");
		request.getSession().setAttribute("LastLoginMail", mail);
		if(isadmin==null){
			User u = new UserDao().getUser(mail);
			if(u==null){
				PrintWriter out = response.getWriter();
				String a = URLEncoder.encode("用户不存在", "UTF-8"); 
				out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
				//response.sendRedirect("Login.jsp");
			}else{
				u = new UserDao().getUser(mail,password);
				if(u==null){
					PrintWriter out = response.getWriter();
					String a = URLEncoder.encode("密码输入错误", "UTF-8"); 
					out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
				}else{
					request.getSession().setAttribute("user", u);
					PrintWriter out = response.getWriter();
					String a = URLEncoder.encode("登录成功", "UTF-8"); 
					out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='listProduct'</script>");
				}
			}
		}else{
			User u = new UserDao().getUser(mail);
			if(u==null){
				PrintWriter out = response.getWriter();
				String a = URLEncoder.encode("用户不存在", "UTF-8"); 
				out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
				//response.sendRedirect("Login.jsp");
			}else{
				if(u.getIsadmin()==1){
					u = new UserDao().getUser(mail,password);
					
					if(u==null){
						PrintWriter out = response.getWriter();
						String a = URLEncoder.encode("密码输入错误", "UTF-8"); 
						out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
					}else{
						request.getSession().setAttribute("user", u);
						PrintWriter out = response.getWriter();
						String a = URLEncoder.encode("登录成功", "UTF-8"); 
						out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='listProduct'</script>");
					}
				}else{
					PrintWriter out = response.getWriter();
					String a = URLEncoder.encode("璇ョ敤鎴蜂笉鏄鐞嗗憳", "UTF-8"); 
					out.print("<script>alert(decodeURIComponent('"+a+"'));window.location.href='Login.jsp'</script>");
				}
				
			}
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
