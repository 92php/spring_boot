package com.imooc.mall.filter;


import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 管理员校验器
 */
public class AdminFilter implements Filter {

    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute(Constant.IMOOC_MALL_USER);
        if(currentUser == null){
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" +
                    "  \"status\": "+ ImoocMallExceptionEnum.NEED_LOGIN.getCode() +",\n" +
                    "  \"msg\": "+ ImoocMallExceptionEnum.NEED_LOGIN.getMsg() +",\n" +
                    "  \"data\": null\n" +
                    "}");
            out.flush();
            out.close();
            return;
        }
        Boolean adminRole = userService.checkAdminRole(currentUser);
        if(adminRole){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" +
                    "  \"status\": "+ ImoocMallExceptionEnum.NEED_ADMIN.getCode() +",\n" +
                    "  \"msg\": "+ ImoocMallExceptionEnum.NEED_ADMIN.getMsg() +",\n" +
                    "  \"data\": null\n" +
                    "}");
            out.flush();
            out.close();
        }
    }

    @Override
    public void destroy() {

    }
}
