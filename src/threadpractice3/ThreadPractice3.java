/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpractice3;

import java.util.Scanner;

/**
 *
 * @author eric
 */
public class ThreadPractice3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Press Enter key to stop counting");
        Thread counter = new Thread(new Counter());
        counter.start();
        Scanner sc = new Scanner(System.in);
        String s = "start";
        while(!s.equals("")){ //wait for the user to press enter
            
            s = sc.nextLine(); 
        }
        counter.interrupt();
    }
   
    
}

class Counter implements Runnable {

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        int count = 1;
        while(!ct.isInterrupted()){
            System.out.println(ct.getName() + " count " + count);
            count++;
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                break;
            }
        }
        System.out.println(ct.getName() + " interrupted. ");
    }
    
}
