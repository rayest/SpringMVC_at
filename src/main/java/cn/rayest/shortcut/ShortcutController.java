package cn.rayest.shortcut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
@Controller
public class ShortcutController {
    @RequestMapping(value = "/shortcut")
    public String getShortcut(){
        return "shortcut";
    }
}
