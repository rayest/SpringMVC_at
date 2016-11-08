package cn.rayest.shortcut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rayest on 2016/11/8 0008.
 * 对应的快捷页面转向是在配置文件中以重写的方法实现的
 */
@Controller
public class ShortcutController {
    @RequestMapping(value = "/shortcut/long")
    public String getShortcut(){
        return "shortcut";
    }
}
