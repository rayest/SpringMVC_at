package cn.rayest.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rayest on 2016/11/8 0008.
 * @param produces 可以定制返回的 response 媒体类型和字符集
 */
@RestController
@RequestMapping("/rest")
public class AnnotationRestController {
    @RequestMapping(value = "/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public AnnotationEntity getJson(AnnotationEntity annotationEntity) {
        return new AnnotationEntity(annotationEntity.getId(), annotationEntity.getName());
    }

    @RequestMapping(value = "/xml", produces = "application/xml;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public AnnotationEntity getXml(AnnotationEntity annotationEntity){
         return new AnnotationEntity(annotationEntity.getId(), annotationEntity.getName());
    }

    @RequestMapping(value = "/request/param", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String getRequestParam(Long id, HttpServletRequest request){
        return "url: " + request.getRequestURL() + " can access, id: " + id;
    }

    @RequestMapping(value = "/object", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String getObject(AnnotationEntity annotationEntity, HttpServletRequest request){
        return "url: " + request.getRequestURL() + " can access, annotationEntity id: " + annotationEntity.getId() + " annotationEntity name: " + annotationEntity.getName();
    }

}
