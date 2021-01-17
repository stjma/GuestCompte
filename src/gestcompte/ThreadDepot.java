/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestcompte;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author info1
 */
public class ThreadDepot extends Thread{
    private Compte compte;

    public ThreadDepot(Compte compte,String nomThread) {
        super(nomThread);
        this.compte = compte;       
    }
    
    @Override
    public void run(){
        for(int cpt = 0;cpt <=100;cpt++){
            this.compte.depot(100);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1,50));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDepot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
