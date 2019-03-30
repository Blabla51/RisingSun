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
public class IA_Pourrie {
    public int tour = 0;
    public Vector<Action> v;
    public Player p;

    
    public IA_Pourrie(Player p) {
        this.p = p;
        this.v = new Vector<Action>();
        this.v.add(new Action(p.id, 0, 27, 15));
        this.v.add(new Action(p.id, 27, 1, 20));
        this.v.add(new Action(p.id, 1, 4, 25));
        this.v.add(new Action(p.id, 4, 17, 30));
        this.v.add(new Action(p.id, 17, 23, 35));
        this.v.add(new Action(p.id, 23, 30, 40));
        this.v.add(new Action(p.id, 30, 26, 45));
    }


    public Action[] play(Map m){
        Vector<Action> a = new Vector<Action>();
        int i;
        for(i = 0; i < ((this.tour - this.tour%3)/3+1) && i < this.v.size(); i++)
        {
            a.add(new Action(v.get(i)));
        }
        if(tour < 30)
            a.get(i-1).qtCode = 5;
        this.tour ++;
        return (Action[])a.toArray(new Action[a.size()]);
    }
}