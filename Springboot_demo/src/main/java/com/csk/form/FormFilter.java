package com.csk.form;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.swing.text.Style;
import java.io.IOException;

/**
 * @author csk
 * @date 2023/11/22 21:23
 */
@WebFilter(filterName = "FormFilter", urlPatterns = {"/*"})
public class FormFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("FormFilter初始化完成");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException{
        System.out.println("FormFilter开始工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy(){
        System.out.println("FormFilter已销毁");
    }


}
