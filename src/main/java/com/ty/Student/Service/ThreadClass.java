package com.ty.Student.Service;

import ch.qos.logback.core.CoreConstants;
import com.ty.Student.controller.StudentController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadClass extends Thread {

    private static final Logger logger = LogManager.getLogger(ThreadClass.class);


    public synchronized void run(){

        try{

            for (int i = 0; i < 10; i++) {

                Thread.sleep(1000);
                logger.info("This is info level");
            }


        }catch(Exception e){
            logger.info(e);
        }


    }

    public static void main(String args[]){

        ThreadClass thread = new ThreadClass();
        thread.setName("Thread1");
        ThreadClass thread2 = new ThreadClass();
        thread2.setName("Thread2");
        thread.start();
        logger.info(thread.getName());
        thread2.start();
        logger.info(thread2.getName());

    }
}
