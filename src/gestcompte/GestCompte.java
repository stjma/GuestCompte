/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestcompte;

/**
 *
 * @author info1
 */
public class GestCompte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Compte compte = new Compte(200);
        
        new ThreadDepot(compte, "Depot_1").start();
        new ThreadDepot(compte, "Depot_2").start();
        
        new Thread(new ThreadRetrait(compte),"retrait_1").start();
        new Thread(new ThreadRetrait(compte),"retrait_2").start();
    }
    
}
