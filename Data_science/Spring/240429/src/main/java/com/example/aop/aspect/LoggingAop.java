package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class LoggingAop {

        @Pointcut(value = "execution(* com.example.aop.controller..*.*(..))" )
        private void cut() {}
    
        @Before(value ="execution(* com.example.aop.controller..*.*(..))" )
        public void before(JoinPoint joinpoint) {
            // System.out.println("app before");
            var buffers = new StringBuilder();
            buffers.append("class name:");
            buffers.append(joinpoint.getTarget().getClass().getSimpleName());
            buffers.append(", method name: ");
            buffers.append(joinpoint.getSignature().getName());
            buffers.append("\n");

            Arrays.stream(joinpoint.getArgs()).forEach(a->{
                buffers.append("args type = ");
                buffers.append(a.getClass().getSimpleName()+",");
                buffers.append("args vale = ");
                buffers.append(a);
                buffers.append("\n");
            });

        }
    }
