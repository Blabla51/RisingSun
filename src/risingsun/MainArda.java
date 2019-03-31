/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import java.util.ArrayList;
import static risingsun.GameServer.*;

/**
 *
 * @author ardayigit
 */
public class MainArda {
    
    public static void main(String[] args) throws Exception {
        
        //reset(); 
        Player p1 = join("monia");
        System.out.println("p1 id: " + p1.id);
        Player p2 = join("monia2");
        System.out.println("p2 id: " + p2.id);
        
        startGame();
        waitTurn(p1);
        Node[] n = getBoard(p1);
        Plateau plateau = new Plateau(n); 
        Node[] n2 = getVisible(p1);
        plateau.updateOwner(n2); 
        
        ArrayList<Integer> al = new ArrayList<>(); 
        for (int i = 0; i < n2.length; i++) {
            al.add(n2[i].id); 
        }
        
        /*for (int i = 0; i < plateau.nodes.length; i++) {
            if (al.contains(i)) {
                NeighborNode[] nn = plateau.nodes[i].neighbors; 
                for (int j = 0; j < nn.length; j++) {
                    System.out.println(nn[j].id + "\t" + nn[j].debit);
                }
            }
        }*/
        
        
        
        /*int myid = -1; 
        for (int i = 0; i < n2.length; i++) {
            if (n2[i].owner == p1.id) {
                myid = n2[i].id; 
                break; 
            }
        }
        
        int hisid = -1; 
        for (int i = 0; i < n2.length; i++) {
            if (n2[i].owner != p1.id) {
                hisid = n2[i].id; 
                break; 
            }
        }
        
        int delta = plateau.nodes[myid].qtCode - plateau.nodes[hisid].qtCode; 
        
        int force = -1; 
        if (delta > 0) {
            force = plateau.nodes[hisid].qtCode + 1; 
        } else {
            force = plateau.nodes[myid].qtCode; 
        }
        
        if (myid != -1 && hisid != -1) {
            Action a = new Action(p1.id, myid, hisid, force); 
        }
        
        endTurn(p1); 
        
        
        
        
        for (int i = 0; i < plateau.nodes.length; i++) {
            System.out.println(plateau.nodes[i].toString());
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");*/
        
        
        //for (int i = 0; i < n2.length; i++) {
        //    System.out.println(n2[i].toString());
        //}
        //Action a = new Action(p1.id, 0,2,10);
        //Action[] at = new Action[1];
        //at[0] = a; 
        //System.out.println(playAction(p1, at));
        //endTurn(p1);

        
        
    }
    
}
