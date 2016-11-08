package cn.rayest.statics;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rayest on 2016/11/8 0008.
 * 自定义拦截器：计算每次请求的处理时间
 */
public class StaticInterceptor extends HandlerInterceptorAdapter {
    // 请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    // 请求完成后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为：" + new Long(endTime - startTime));
        request.setAttribute("handlingTime", endTime - startTime);
    }
}
