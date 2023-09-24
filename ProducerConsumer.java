import java.util.*;
import java.util.ArrayList;

class producer implements Runnable{
     List<Integer> Buffer=null;
     private int i=0;
     final int max=10;
     producer(List<Integer>Buffer)
     {
         this.Buffer=Buffer;
     }
     public void produce(int i)throws InterruptedException
     {
       synchronized(Buffer)
       {
           while(Buffer.size()== max)
           {
               System.out.println("Producer is Waiting due to Buffer is Full");
               Buffer.wait();
           }
       }
       Buffer.add(i);
           System.out.println("Producer Producing");
           Thread.sleep(350);
       synchronized(Buffer)
       {
           
           Buffer.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                 i++;
                 produce(i);
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
     }
};

class consumer implements Runnable{

};

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> B=new ArrayList<Integer>();
        Thread p=new Thread(new producer(B));
        Thread c=new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}