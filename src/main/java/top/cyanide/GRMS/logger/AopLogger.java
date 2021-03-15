package top.cyanide.GRMS.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.cyanide.GRMS.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bai
 * 日志记录器，采用SpringBoot所使用的logback记录日志
 */
@Aspect
@Component
public class AopLogger {
    private final Logger logger = LoggerFactory.getLogger(AopLogger.class);

    @Pointcut("execution(public * com.autoepacs.production..*.*(..))")
    public void productionLog() {
    }

    @Before(value = "productionLog()")
    public void logBefore(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;
        if (requestAttributes != null) {
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
            logger.info("------------------------------------------------------------------------------");
            logger.info("| UserName:        " + request.getSession().getAttribute("userName"));
            logger.info("| Interface:       " + request.getRequestURL().toString());
            logger.info("| RequestMethod:   " + request.getMethod());
            logger.info("| RequestAddress:  " + request.getRemoteAddr());
            logger.info("| RequestPort:     " + request.getRemotePort());
            logger.info("| MethodInvoked:   " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("| AccessTime:      " + DateUtils.date());
            logger.info("------------------------------------------------------------------------------");
        }
    }

    @AfterReturning(returning = "returnOb", pointcut = "productionLog()")
    public void logAfterReturning(JoinPoint joinPoint, Object returnOb) {
        logger.info("------------------------------------------------------------------------------");
        logger.info("| MethodInvoked: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("| ReturnedData:  " + returnOb);
        logger.info("| AccessTime:    " + DateUtils.date());
        logger.info("------------------------------------------------------------------------------");
    }

    @AfterThrowing(pointcut = "productionLog()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.info("------------------------------------------------------------------------------");
        logger.info("| MethodInvoked:    " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("| ExceptionOccured: " + ex);
        logger.info("| AccessTime:       " + DateUtils.date());
        logger.info("------------------------------------------------------------------------------");
    }
}
