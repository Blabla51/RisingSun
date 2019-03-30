 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import static risingsun.HTTPHelper.*;
import org.json.*;

/**
 *
 * @author ardayigit
 */
public class GameServer {
    
    public static String host = "http://localhost:8080/"; 
    
    public static Player join(String iaName) throws Exception {
        String str[] = post(host + "IA/Join","IAName=" + iaName); 
        JSONObject obj = new JSONObject(str[1]); 
        
        return new Player(obj.getInt("id"), obj.getString("token")); 
        // ajouter JSON parser et renvoyer un objet
    }
    
    public static void reset() throws Exception {
        String[] str = get(host + "Reset"); 
    }
    
    public static void chooseMap(String nameMap) throws Exception {
        String[] str = get(host + "Start/ChooseMap?Map=" + nameMap); 
    }
    
    public static String startGame() throws Exception {
        String[] str = get(host + "Start/Game"); 
        return str[1]; 
    }
    
    public static String playAction(Player p, Action[] actions) throws Exception {
        
        JSONArray ja = new JSONArray(); 
        for (int i = 0; i < actions.length; i++) {
            ja.put(actions[i].toJSON()); 
        }
        
        String[] str = post(host + "PlayAction","token=" + p.token, ja.toString()); 
        
        return str[1]; 
    }
    
    public static void getBoard() throws Exception {
        String[] str = get(host + "Get/Board"); 
        
        JSONObject obj = new JSONObject(str[1]); 
        String status = obj.getString("status"); 
        JSONObject object = obj.getJSONObject("object"); 
        
        JSONArray plateau = object.getJSONArray("plateau"); 
        
        Node[] nodes = new Node[plateau.length()]; 
        
        for (int i = 0; i < plateau.length(); i++) {
            JSONObject obji = plateau.getJSONObject(i); 
            JSONArray Jneighbors = obji.getJSONArray("neighbors"); 
            NeighborNode[] neighbors = new NeighborNode[Jneighbors.length()]; 
            for (int j = 0; j < neighbors.length; j++) {
                neighbors[j] = new NeighborNode(Jneighbors.getJSONObject(j).getInt("id"), Jneighbors.getJSONObject(j).getInt("debit")); 
            }
            nodes[i] = new Node(
                    obji.getInt("id"), 
                    obji.getDouble("coordX"), 
                    obji.getDouble("coordY"), 
                    obji.getInt("production"), 
                    obji.getInt("qtCode"), 
                    neighbors, 
                    obji.getBoolean("bonus"), 
                    obji.getInt("typeBonus"), 
                    obji.getBoolean("isServer"), 
                    obji.getInt("owner")); 
        }
        
    }
    
    public static void getVisible(Player p) throws Exception {
        String[] str = get(host + "Get/Visible?token=" + p.token); 
        JSONObject obj = new JSONObject(str[1]); 
        JSONObject object = obj.getJSONObject("object"); 
        String status = obj.getString("status"); 
        
        JSONArray visible = object.getJSONArray("visible"); 
        
        Node[] nodes = new Node[visible.length()]; 
        
        for (int i = 0; i < visible.length(); i++) {
            JSONObject obji = visible.getJSONObject(i); 
            JSONArray Jneighbors = obji.getJSONArray("neighbors"); 
            NeighborNode[] neighbors = new NeighborNode[Jneighbors.length()]; 
            for (int j = 0; j < neighbors.length; j++) {
                neighbors[j] = new NeighborNode(Jneighbors.getJSONObject(j).getInt("id"), Jneighbors.getJSONObject(j).getInt("debit")); 
            }
            nodes[i] = new Node(
                    obji.getInt("id"), 
                    obji.getDouble("coordX"), 
                    obji.getDouble("coordY"), 
                    obji.getInt("production"), 
                    obji.getInt("qtCode"), 
                    neighbors, 
                    obji.getBoolean("bonus"), 
                    obji.getInt("typeBonus"), 
                    obji.getBoolean("isServer"), 
                    obji.getInt("owner")); 
        }
        
    }
    
    public static void endTurn(Player p) throws Exception{
        String[] str = post(host + "End/Turn", p.token);
    }
        

    public static boolean waitTurn(Player p) throws Exception {
        String[] str = get(host + "Wait?token=" + p.token);  
        return true;
    }

}
