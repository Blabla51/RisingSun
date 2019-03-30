/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import java.util.Vector;

/**
 *
 * @author QB
 */
public class MammamIA {
    public Player p;
    public MammamIA(Player p) {
        this.p =p;
    }
    public Action[] play(Map m){
        Vector<Action> v = new Vector<>();
        //int nbNodes = m.v.size();
        
        for (int i = 0; i < m.v.size(); i++) {  //chaque noeud de la carte
            for (int j = 0; j < m.v.get(i).neighbors.length; j++) { //chaque voisin du noeud
                
            }
        }
        
        return (Action[])v.toArray(new Action[v.size()]);
    }
}
