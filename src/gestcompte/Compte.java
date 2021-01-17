/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestcompte;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author info1
 */
public class Compte {

    private int solde;

    public Compte(int solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    //add
    public synchronized void depot(int montant) {
        this.solde += montant;
        System.out.println(String.format("Le thread %s a fait un depot de %d le nouveau solde est de %d",
                Thread.currentThread().getName(), montant, solde));

        this.notifyAll();

    }

    //remove
    public void retrait(int montant) {
        synchronized (this) {
            while (this.solde < montant) {
                System.out.println(String.format("Le thread %s est en attente d'argent", Thread.currentThread().getName()));

                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            this.solde -= montant;
            System.out.println(String.format("Le thread %s a fait un retrait de %d le nouveau solde est de %d",
                    Thread.currentThread().getName(), montant, solde));

        }

    }
}
