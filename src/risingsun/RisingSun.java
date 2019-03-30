 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import org.json.JSONArray;
import org.json.JSONObject;
import static risingsun.GameServer.*;


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
        Node[] n = getBoard(p1);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i].toString());
        }
        Node[] n2 = getVisible(p1);
        for (int i = 0; i < n2.length; i++) {
            System.out.println(n2[i].toString());
        }
        Action a = new Action(p1.id, 0,2,10);
        Action[] at = new Action[1];
        at[0] = a; 
        System.out.println(playAction(p1, at));
        endTurn(p1);
        
//        String[] str = post("http://localhost:8080/IA/Join","IAName=monia"); 
//        String[] str = get("http://localhost:8080/Reset"); 
//        System.out.println(str[0]);
//        System.out.println(str[1]);
    }
    
}
