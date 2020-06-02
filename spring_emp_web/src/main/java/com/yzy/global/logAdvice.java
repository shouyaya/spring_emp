package com.yzy.global;


import com.yzy.entity.Log;
import com.yzy.entity.Staff;
import com.yzy.serice.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class logAdvice {

    @Resource(name = "logService")
    LogService logService;
    @AfterReturning("execution(* com.yzy.controller.*.*(..)) && !execution(* com.yzy.controller.selfController.*(..))&& !execution(* com.yzy.controller.*.to*(..))")
    public void operationAdvice(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getSignature().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request=(HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff=(Staff) request.getSession().getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }
    @AfterThrowing(throwing = "e",pointcut = "execution(* com.yzy.controller.*.*(..)) && !execution(* com.yzy.controller.selfController.*(..))")
    public void systemAdvice(JoinPoint joinPoint,Throwable e){
        Log log=new Log();
        log.setMoudle(joinPoint.getSignature().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request=(HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff=(Staff) request.getSession().getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }

    @After("execution(* com.yzy.controller.selfController.login(..))")
    public void loginAdvice(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getSignature().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request=(HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff=(Staff) request.getSession().getAttribute("USER");
        if (staff!=null) {
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }else{
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }
        logService.addLoginLog(log);
    }

    @Before("execution(* com.yzy.controller.selfController.logout(..))")
    public void logoutAdvice(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getSignature().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request=(HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff=(Staff) request.getSession().getAttribute("USER");
        if (staff!=null) {
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }else{
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }
        logService.addLoginLog(log);
    }
}
