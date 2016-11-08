package cn.rayest.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
@Controller
public class AdviceController {
    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public String get(@ModelAttribute("message") String message){
        throw new IllegalArgumentException("参数有误，来自 " + "@ModelAttribute:" + message);
    }
}
