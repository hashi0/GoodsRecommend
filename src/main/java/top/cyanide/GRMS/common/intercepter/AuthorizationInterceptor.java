package top.cyanide.GRMS.common.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.cyanide.GRMS.common.constant.ErrorCode;
import top.cyanide.GRMS.model.response.BasicResponse;
import top.cyanide.GRMS.pojo.User;
import top.cyanide.GRMS.sevice.IUserService;
import top.cyanide.GRMS.utils.NumUtils;
import top.cyanide.GRMS.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bai
 * 权限验证拦截器，进行用户认证和获取用户token
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            this.authFailed(response);
            return false;
        }
        User user = this.userService.findUserByToken(token);
        if (user == null) {
            this.authFailed(response);
            return false;
        }
        request.getSession().setAttribute("user", user);
        return true;
    }

    public void authFailed(HttpServletResponse response) throws IOException {
        this.response(response, NumUtils.newRandomInt(), ErrorCode.UNAUTHORIZED, "非法用户，拒绝访问！");
    }

    private void response(HttpServletResponse response, Integer logId, Integer errorCode,
                          String errorMessage) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setStatus(HttpServletResponse.SC_OK);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(errorCode);
        basicResponse.setErrorMessage(errorMessage);
        response.getWriter().println(basicResponse);
    }
}
