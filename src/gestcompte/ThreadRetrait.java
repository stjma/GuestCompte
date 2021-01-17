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
public class ThreadRetrait implements Runnable {
    private Compte compte;

    public ThreadRetrait(Compte compte) {
        this.compte = compte;
    }
    
    @Override
    public void run(){
        for(int cpt = 0;cpt <=50;cpt++){
            this.compte.retrait(150);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1,50));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDepot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
