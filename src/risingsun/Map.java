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
public class Map {
    Vector<Node> v;
    public Map() {
        this.v = new Vector<>();
    }
    Map prediction(){
        Map m = new Map();
        /*INSERT CODE HERE*/
        return m;
    }
    int getProduction(int id){
        int p = 0;
        for (int i = 0; i < v.size(); i++){
            if(v.get(i).id == id){
                p += v.get(i).production;
            }
        }
        return p;
    }
    
}
