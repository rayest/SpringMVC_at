package cn.rayest.asynchronous;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by Rayest on 2016/11/12 0012.
 * 定时任务
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        return new DeferredResult<>(); // 返回给控制器
    }

    @Scheduled(fixedDelay = 5000) // 定时更新 DeferredResult
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
