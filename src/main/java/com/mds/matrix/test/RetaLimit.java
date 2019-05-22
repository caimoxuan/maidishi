package com.mds.matrix.test;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cmx
 * @Date 2019/5/22 22:10
 */
public class RetaLimit {


    private static Integer bucketMaxSize = 6;

    private AtomicInteger token = new AtomicInteger(0);

    RetaLimit(int timeWindow){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                increaseToken();
                System.out.println("重新放入token");
            }
        }, 0, 1000 * timeWindow);
    }

    public void increaseToken(){
        if(isFull()){
            return;
        }
        for(int i = 0; i < bucketMaxSize; i++){
            token.incrementAndGet();
        }
    }

    public int consumeToken(){
        if(token.get() <= 0){
            return token.get();
        }
       return token.decrementAndGet();
    }


    private boolean isFull(){
        return token.get() >= bucketMaxSize-1;
    }


    public static void main(String[] args){
        RetaLimit retaLimit = new RetaLimit(2);
        new Thread(()->{
            while(true){
                int i = retaLimit.consumeToken();
                if(i > 0) {
                    System.out.println("开始消费： " + i);
                }
            }
        }).start();


    }

}
