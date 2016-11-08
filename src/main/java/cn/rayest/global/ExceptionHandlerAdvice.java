package cn.rayest.global;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
@ControllerAdvice // 声明一个控制器建言
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class) // 定义全局处理，value 属性可过滤拦截的条件，这里是拦截所有的异常
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error"); // error 页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute // 将键值对添加到全局，所有注解的 @RequestMapping 的方法可获得此键值对
    public void addAttributes(Model model) {
        model.addAttribute("message", "额外信息");
    }

    @InitBinder // 定制 WebDataBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}
