package cn.rayest.asynchronous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by Rayest on 2016/11/12 0012.
 * 异步的任务是实现是通过控制器从另外一个线程返回一个 DeferredResult
 */
@Controller
public class AsynchronousController {
    @Autowired
    private PushService pushService; // 定时任务

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        return pushService.getAsyncUpdate(); // 返回给客户端
    }
}
