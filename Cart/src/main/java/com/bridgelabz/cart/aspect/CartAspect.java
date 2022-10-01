package com.bridgelabz.cart.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CartAspect {

    @Before(value = "execution(* com.bridgelabz.cart.service.CartService.addCart(..))")
    public void beforeAddCartData(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        System.out.println("Before Method");
        System.out.println("Want to create new cart deatils into the table");
    }

    @After(value = "execution(* com.bridgelabz.cart.service.CartService.addCart(..))")
    public void afterAddCartData(JoinPoint joinPoint){
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("After Method");
        System.out.println("Successfully created new cart details" + arg);
    }

    @Pointcut("within(com.bridgelabz.cart..*)")
    public void authorizationPointCut(){

    }

    @Before("authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticate the request..");
    }
}
