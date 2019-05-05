package com.mds.matrix.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.common.constant.CustomerConstant;
import com.mds.matrix.common.constant.ErrorEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author cmx
 * @date 2019/5/5
 */
@WebFilter(urlPatterns = {"/cus/*"})
public class CustomerAuthCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object openId = session.getAttribute(CustomerConstant.SESSION_OPEN_ID);
        if(openId == null){
            HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter responseWriter = httpServletResponse.getWriter();
            ApiResult apiResult = new ApiResult();
            apiResult.fail(ErrorEnum.AUTH_FAIL);
            responseWriter.write(new ObjectMapper().writeValueAsString(apiResult));
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
