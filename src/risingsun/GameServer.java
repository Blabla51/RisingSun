 
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
    
    public static String chooseMap(String nameMap) throws Exception {
        String[] str = get(host + "Start/ChooseMap?Map=" + nameMap); 
        return str[1];
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
        //System.out.println(ja.toString());
        String[] str = post(host + "PlayAction","Token=" + p.token, ja.toString()); 
        
        return str[1]; 
    }
    
    public static Node[] getBoard(Player p) throws Exception {
        String[] str = get(host + "Get/Board?Token=" + p.token); 
        
        JSONObject obj = new JSONObject(str[1]); 
        String status = obj.getString("status");
        //System.out.println(str[1]);
        JSONObject object = obj.getJSONObject("object"); 
        
        JSONArray plateau = object.getJSONArray("plateau"); 
        
        Node[] nodes = new Node[plateau.length()]; 
        
        for (int i = 0; i < plateau.length(); i++) {
            JSONObject obji = plateau.getJSONObject(i); 
            JSONArray Jneighbors = obji.getJSONArray("neighbors"); 
            NeighborNode[] neighbors = new NeighborNode[Jneighbors.length()]; 
            for (int j = 0; j < neighbors.length; j++) {
                neighbors[j] = new NeighborNode(Jneighbors.getJSONObject(j).getInt("id"), 0);//Jneighbors.getJSONObject(j).getInt("debit")); 
            }
            nodes[i] = new Node(
                    obji.getInt("id"), 
                    obji.getDouble("coordX"), 
                    obji.getDouble("coordY"), 
                    obji.getInt("production"), 
                    /*obji.getInt("qtCode")*/0, 
                    neighbors, 
                    obji.getBoolean("bonus"), 
                    obji.getInt("typeBonus"), 
                    obji.getBoolean("isServer"), 
                    /*obji.getInt("owner")*/-1); 
        }
        
        return nodes;
        
    }
    
    public static Node[] getVisible(Player p) throws Exception {
        String[] str = get(host + "Get/Visible?Token=" + p.token); 
        JSONObject obj = new JSONObject(str[1]); 
        //System.out.println(str[1]);
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
        return nodes;
    }
    
    public static String endTurn(Player p) throws Exception{
        String[] str = post(host + "End/Turn", "Token=" + p.token);
        return str[1];
    }
        

    public static boolean waitTurn(Player p) throws Exception {
        String[] str = get(host + "Wait?Token=" + p.token); 
        JSONObject jo = new JSONObject(str[1]); 
        return jo.getBoolean("wait"); 
    }
    
    
    public static int getTurn(Player p) throws Exception {
        String[] str = get(host + "Get/Turn?Token=" + p.token); 
        JSONObject jo = new JSONObject(str[1]); 
        return jo.getInt("turn"); 
    }
    

}
