/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.project;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * @author dell
 */ class Philosopher extends Thread   
{  

 ReentrantLock  FirstAccount;
  ReentrantLock    SecondAccount;

  

 

    public Philosopher(ReentrantLock  leftFork,  ReentrantLock  rightFork) {
       
        
        this.FirstAccount = leftFork;
        this.SecondAccount = rightFork;
    
    }

   

   
  
    
  
    
private void doAction(String action) throws InterruptedException {
        System.out.println(  Thread.currentThread().getName()+ " " + action);
      
  
        
        Thread.sleep(((int) (Math.random() * 100)));
    }
    public void run() {
        
       while (true) {
           try {
               doAction(" unActive");
           } catch (InterruptedException ex) {
               Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
           }
           
              FirstAccount.lock();
    try { 
        SecondAccount.lock();
        try { 
         doAction("can use two account- acess ");
        }         catch (InterruptedException ex) {
                      Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
                  } finally {
          SecondAccount.unlock();
		}
    } finally { 
        FirstAccount.unlock();
	}
               
           
           
               
              
       
             
       
   }
    
    
     
     
    
   
   
    }} 
    
  