package org.phoenix.speed.domain.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.phoenix.speed.exception.RestResult;
import org.phoenix.speed.exception.ResultCode;
import org.phoenix.speed.exception.exceptions.global.UnLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class ShiroFormAuthenticationFilter  extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);

    /**
     * 未登录访问请求处理
     * @param request
     * @param response
     * @return
     * @throws UnLoginException
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws UnLoginException,Exception {

        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                return true;
            }
        } else {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;
            if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            } else {
                RestResult.writeResponse(response, ResultCode.UN_LOGIN);
                return false;
            }
        }
    }

}
