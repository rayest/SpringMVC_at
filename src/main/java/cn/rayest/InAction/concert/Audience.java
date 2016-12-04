package cn.rayest.InAction.concert;

import org.aspectj.lang.annotation.*;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@Aspect
public class Audience {
    // 定义切点, 切点表达式
    @Pointcut("execution(** concert.Performance.perform(..)")
    public void performance() {
    }

    // 通知方法会在目标方法调用之前执行
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    // 通知方法会在目标方法调用之前执行
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    // 通知方法会在目标方法返回后调用
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    // 通知方法会在目标方法抛出异常后调用
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
