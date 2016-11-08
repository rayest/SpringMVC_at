package cn.rayest.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rayest on 2016/11/8 0008.
 * @param produces 可以定制返回的 response 媒体类型和字符集
 */
@Controller
@RequestMapping("/normal")
public class AnnotationController {
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String show(HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathVariable/{string}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showPath(@PathVariable("string") String string, HttpServletRequest request){
        return "url: " + request.getRequestURL() + " can access, string: " + string;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRequestParam(Long id, HttpServletRequest request){
        return "url: " + request.getRequestURL() + " can access, id: " + id;
    }

    @RequestMapping(value = "/object", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String showObject(AnnotationEntity annotationEntity, HttpServletRequest request){
        return "url: " + request.getRequestURL() + " can access, annotationEntity id: " + annotationEntity.getId() + " annotationEntity name: " + annotationEntity.getName();
    }
}
