package cn.rayest.converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rayest on 2016/11/9 0009.
 */
@Controller
public class MessageConverterController {
    @RequestMapping(value = "/convert", method = RequestMethod.GET, produces = "application/rayest")
    @ResponseBody
    public Message convert(@RequestBody Message message) {
        return message;
    }
}
