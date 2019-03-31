 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import org.json.JSONArray;
import org.json.JSONObject;
import static risingsun.GameServer.*;
import java.lang.*;


/**
 *
 * @author QB
 */
public class RisingSun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // LOVE STRAS
        
        reset(); 
        Player p1 = join("monia");
        waitTurn(p1);
        Player p2 = join("monia2");
        waitTurn(p2);
        //System.out.println(chooseMap("map0"));
        
        System.out.println(startGame());
        /*Node[] n = getBoard(p1);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i].toString());
        }*/
        /*System.out.println("P1");
        Node[] n2 = getVisible(p1);
        for (int i = 0; i < n2.length; i++) {
            //System.out.println(n2[i].toString());
        }
        
        System.out.println("P2");
        Node[] n3 = getVisible(p2);
        for (int i = 0; i < n3.length; i++) {
            //System.out.println(n3[i].toString());
        }
        Action a = new Action(p1.id, 0,2,10);
        Action[] at = new Action[1];
        at[0] = a; 
        System.out.println(playAction(p1, at));
        System.out.println(endTurn(p1));*/
        
        IA_Pourrie iap = new IA_Pourrie(p1);
        MammamIA mia = new MammamIA(p2);
        
        for (int i = 0; i < 3; i++) {
            //System.out.println("p1");
            System.out.println(playAction(p1, iap.play(new Map())));
            //playAction(p1, iap.play(new Map()));
            //endTurn(p1);
            //endTurn(p2);
            Node[] n3 = getVisible(p2);
            //for (int p = 0; p < n3.length; p++) {
            System.out.println(i);
            System.out.println(n3[0].qtCode);
            //}
            //System.out.println("p2");
            //System.out.println(playAction(p2, mia.play(new Map())));
            //System.out.println(endTurn(p1));
            //System.out.println(endTurn(p2));
            System.out.println("wait : ");
            System.out.println(waitTurn(p1));
            while(waitTurn(p1)){
                Thread.sleep(1);
            };
            /*while(waitTurn(p2)){
                Thread.sleep(1);
            };*/
            
            System.out.println("");
            //Thread.sleep(10);
            //Thread.sleep(500);
        }
        
        
        
//        String[] str = post("http://localhost:8080/IA/Join","IAName=monia"); 
//        String[] str = get("http://localhost:8080/Reset"); 
//        System.out.println(str[0]);
//        System.out.println(str[1]);
    }
    
}
