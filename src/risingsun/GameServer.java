/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import static risingsun.HTTPHelper.*;
import org.json.JSONObject;

/**
 *
 * @author ardayigit
 */
public class GameServer {
    
    public static String host = "http://localhost:8080/"; 
    
    public static String token = ""; 
    
    public static void join(String iaName) throws Exception {
        String str[] = post(host + "IA/Join","IAName=" + iaName); 
        JSONObject obj = new JSONObject(str[1]); 
        String id = obj.getString("id"); 
        String status = obj.getString("status"); 
        token = obj.getString("token"); 
        
        // ajouter JSON parser et renvoyer un objet
    }
    
    public static void reset() throws Exception {
        String[] str = get(host + "Reset"); 
    }
    
    public static void chooseMap(String nameMap) throws Exception {
        String[] str = get(host + "Start/ChooseMap?Map=" + nameMap); 
    }
    
    public static void startGame() throws Exception {
        String[] str = get(host + "Start/Game"); 
    }
    
    public static void playAction(String token) throws Exception {
        String[] str = post(host + "PlayAction",token); 
    }
    
    public static void getBoard(String token) throws Exception {
        String[] str = get(host + "Get/Board"); 
    }
    
}
