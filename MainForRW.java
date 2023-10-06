/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ritesh
 */
import java.util.*;
import java.util.concurrent.Semaphore;
public class MainForRW {
    static int rc = 0;
    static Semaphore s = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    
        static class Reader implements Runnable{
            public void run(){
                try{
                s.acquire();
                rc = rc+1;
                if(rc == 1){
                    wrt.acquire();
            }
                s.release();
                System.out.println(Thread.currentThread().getName()+" read");
                Thread.sleep(1000);
                s.acquire();
                rc = rc -1;
                if(rc == 0){
                    wrt.release();
                }
                s.release();
            }
                catch(Exception e){
                    
                }
                
        }
    }
    
    static class Writer implements Runnable{
        public void run(){
            try{
               wrt.acquire();
               System.out.println(Thread.currentThread().getName()+" write");
               Thread.sleep(1000);
               wrt.release();
            }
            catch(Exception e){
                
            }
        }
    }

    public static void main(String args[]){
        Thread t1 = new Thread(new Reader());
        t1.setName("Reader");
        Thread t2 = new Thread(new Reader());
        t2.setName("Reader 2");
        Thread t3 = new Thread(new Writer());
        t3.setName("Writer1");
        Thread t4 = new Thread(new Writer());
        t4.setName("Wtiter 2");
        t4.start();
        t1.start();
        t3.start();
        t2.start();
            
    
            
    }
}