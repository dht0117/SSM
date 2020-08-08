package cn.itcast.Servlet;

import cn.itcast.DAO.UserDao;
import cn.itcast.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
        UserDao userDao = new UserDao();
        User user=userDao.find(username,password);

        if(user==null){
            request.setAttribute("message","用户名或密码错误");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }

        //如果不为空
        request.getSession().setAttribute("user",user);
        request.setAttribute("message","登陆成功");

        //利用Cookie保存信息
        Cookie cookie=new Cookie("autoLogin",user.getUsername()+"."+user.getPassward());

        cookie.setMaxAge(Integer.parseInt(request.getParameter("time"))*60);
        //把Cookie返回给浏览器
        response.addCookie(cookie);

        request.getRequestDispatcher("/message.jsp").forward(request,response);
    }
}
