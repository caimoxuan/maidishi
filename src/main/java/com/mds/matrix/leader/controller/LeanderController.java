package com.mds.matrix.leader.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RecursiveTask;

/**
 * @author cmx
 * @Date 2019/5/4 14:44
 */
@Slf4j
@RestController
@RequestMapping("/lea/leader")
public class LeanderController {

    public static void main(String[] args) throws InterruptedException {

//        Class<LeanderController> leanderControllerClass = LeanderController.class;
//        Method[] methods = leanderControllerClass.getMethods();
//
//        for(Method m : methods){
//            Parameter[] parameters = m.getParameters();
//            for(Parameter p : parameters){
//                String name = p.getName();
//                Type parameterizedType = p.getParameterizedType();
//            }
//        }
        System.out.println("start");
        new CountDownLatch(1).await();
        System.out.println("end");


    }

    class Fj extends RecursiveTask<Map<String, Integer>> {


        @Override
        protected Map<String, Integer> compute() {
            return null;
        }
    }


    public String test(String testString){
        System.out.println("test");
        return "test";
    }


}
