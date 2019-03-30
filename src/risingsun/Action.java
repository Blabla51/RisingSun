/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ardayigit
 */
public class Action {
    
    public int owner; 
    public int from; 
    public int to; 
    public int qtCode; 

    public Action(int owner, int from, int to, int qtCode) {
        this.owner = owner;
        this.from = from;
        this.to = to;
        this.qtCode = qtCode;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jo = new JSONObject(); 
        jo.put("owner", owner); 
        jo.put("from", from); 
        jo.put("to", to); 
        jo.put("qtCode", qtCode); 
        return jo; 
    }
    
}
