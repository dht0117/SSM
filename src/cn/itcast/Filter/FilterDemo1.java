package cn.itcast.Filter;

import cn.itcast.DAO.UserDao;
import cn.itcast.User.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //如果用户没有关闭浏览器，就不需要cookie拼接
        if(request.getSession().getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        Cookie[] cookies=request.getCookies();
        String value=null;
        for (int i=0;cookies!=null&&i<cookies.length;i++){
            if (cookies[i].getName().equals("autoLogin")){
                value=cookies[i].getValue();
            }
        }
        //得到cookie的用户名和密码
        if(value!=null){
            String username=value.split("\\.")[0];
            String password=value.split("\\.")[1];
            UserDao userDao = new UserDao();
            User user=userDao.find(username,password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
            }
        }
        //filterChain.doFilter(request, response);
        }



    @Override
    public void destroy() {

    }
}
