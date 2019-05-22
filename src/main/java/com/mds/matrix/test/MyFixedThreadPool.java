package com.mds.matrix.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author cmx
 * @Date 2019/5/20 21:17
 */
public class MyFixedThreadPool {


    private LinkedBlockingQueue<Runnable> blockingQueue;

    private boolean isWorking = true;

    private List<Worker> workers;


    private class Worker extends Thread{

        private MyFixedThreadPool myFixedThreadPool;

        Worker(MyFixedThreadPool myFixedThreadPool){
            this.myFixedThreadPool = myFixedThreadPool;
        }

        @Override
        public void run() {
            while(this.myFixedThreadPool.isWorking) {
                try {
                    Runnable take;
                    if(this.myFixedThreadPool.isWorking) {
                        take = myFixedThreadPool.blockingQueue.take();
                    }else{
                        take = myFixedThreadPool.blockingQueue.poll();
                    }
                    if(take != null) {
                        take.run();
                        System.out.println("开启线程" + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MyFixedThreadPool(int coreSize, int queueSize){
        blockingQueue = new LinkedBlockingQueue<>(queueSize);
        workers = Collections.synchronizedList(new ArrayList<>());
        for(int i = 0; i < coreSize; i++){
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    public boolean submit(Runnable runnable){
        if(this.isWorking) {
            return this.blockingQueue.offer(runnable);
        }else{
            return false;
        }

    }

    public void execute(Runnable runnable) throws InterruptedException {
        this.blockingQueue.put(runnable);
    }

    public void shotdown(){
        this.isWorking = false;

        for(Worker worker : this.workers){
            if(Thread.State.WAITING == worker.getState() || Thread.State.BLOCKED == worker.getState()){
                worker.interrupt();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException{
        MyFixedThreadPool myFixedThreadPool = new MyFixedThreadPool(3, 100);
        for(int i = 0; i < 10; i++){
            myFixedThreadPool.execute(() -> {
                System.out.println("线程载入");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        myFixedThreadPool.shotdown();


    }


}
