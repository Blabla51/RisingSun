/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

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
        join("monia"); 
        join("monia2"); 
        System.out.println(GameServer.token);
        System.out.println(startGame()); 
        
//        String[] str = post("http://localhost:8080/IA/Join","IAName=monia"); 
//        String[] str = get("http://localhost:8080/Reset"); 
//        System.out.println(str[0]);
//        System.out.println(str[1]);
    }
    
}
