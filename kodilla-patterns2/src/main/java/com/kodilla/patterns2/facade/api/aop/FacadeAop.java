package com.kodilla.patterns2.facade.api.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeAop.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId) && target(object)")
    public void logEvent(final OrderDto order, final long userId, final Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + order + ", " + userId);
    }
}
