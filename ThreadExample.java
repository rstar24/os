/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class ThreadExample implements Runnable
{
	ArrayList<Integer> b = new ArrayList<Integer>();

    public void run()
    {
		
		try{
			for(int i = 0 ; i <=10 ; i++)
			{
				//Thread.sleep(250);
				b.add(i);
			}
			System.out.println(b);
			System.out.println(b.remove(0));
				for(int i = 0; i <= 10; i++){
					Thread.sleep(250);
					System.out.println(i);
				}
		 }

		catch(Exception e){
			System.out.println(e);
		}        
    }


	public static void main(String[] args) {
	    
		Thread t1 = new Thread(new ThreadExample());
		t1.start();
		
		Thread t2 = new Thread (new ThreadExample());
		t2.start();
		
	}
}
