package com.sly.c2cpay.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CodeUtils {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> task = new FutureTask<>(CodeUtils::getProductId);
            Thread thread = new Thread(task);
            thread.start();
            try {
                System.out.println(task.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);
//        Timestamp timestamp = Timestamp.valueOf(format);




    }
    public synchronized static int getProductId(){
        Random random = new Random();
        int number=random.nextInt(90)+ 10;
        return (int) System.currentTimeMillis()+number;
    }

    public synchronized  static int getTradeId(){
        Random random = new Random();
        int number=random.nextInt(900)+ 100;
        return (int) System.currentTimeMillis()+number;
    }
}
