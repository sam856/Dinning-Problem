package os.project;

import java.util.Scanner;
import java.util.concurrent.Semaphore;  
import java.util.concurrent.ThreadLocalRandom;  
import java.util.concurrent.locks.ReentrantLock;
public class DiningPhilosophersProblem  
{  


public static void main(String args[]) throws InterruptedException   
{  
     Scanner Input = new Scanner(System.in);
     System.out.println("Enter Number Of User : ");
     
      int userName = Input.nextInt();
       
      Philosopher[]  users  = new Philosopher[userName];
    
       ReentrantLock  [] account = new ReentrantLock  [users.length];
             
                for (int i3 = 0; i3 < account.length; i3++) {
                    account[i3] = new ReentrantLock (true);
                }   for (int i7 = 0; i7 < users.length; i7++) {
                     ReentrantLock Firstaccount = account[i7];
                     ReentrantLock Secondaccount = account[(i7 + 1) % account.length];
                    if (i7 == users.length - 1) {
                        
                        users[i7] = new Philosopher(Secondaccount, Firstaccount);
                        
                    } else {
                        users[i7] = new Philosopher(Firstaccount, Secondaccount);
                    }  
                    
                    Thread t = new Thread(users[i7], "Users " + (i7 + 1));
                    t.start();
               
         
            
        }  
}
       
        
   
}