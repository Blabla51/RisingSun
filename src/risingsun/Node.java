/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

/**
 *
 * @author ardayigit
 */
public class Node {
    
    public int id; 
    public double coordX; 
    public double coordY; 
    public int production; 
    public int qtCode; 
    public NeighborNode[] neighbors; 
    public boolean bonus; 
    public int typeBonus; 
    public boolean isServer; 
    public int owner;
    public boolean next2neutral;
    public boolean next2ennemis;
    public boolean farFromEnnemis;
    public boolean next2next2ennemis;
    

    public Node(int id, double coordX, double coordY, int production, int qtCode, NeighborNode[] neighbors, boolean bonus, int typeBonus, boolean isServer, int owner) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.production = production;
        this.qtCode = qtCode;
        this.neighbors = neighbors;
        this.bonus = bonus;
        this.typeBonus = typeBonus;
        this.isServer = isServer;
        this.owner = owner;
        this.next2ennemis = false; // Change avec fonction update
        this.next2neutral = false; // idem
        this.next2next2ennemis = false; // Change avec fonction update
        
    }
    @Override public String toString(){
        String s = "";
        s += "Node : \n id = " + id + "\n x = " + coordX + "\n y = " + coordY + "\n" + "production : " + production + "qtCode = " + qtCode + "\n";
        for (int i = 0; i < neighbors.length; i++) {
            s += "Neighbors[" + i + "] id : " + neighbors[i].id + "\n";
        }
        s += "owner = " + owner + "\n";
        return s;
    }
    
    // A faire par la suite
    public void update(){
        
    }
   
}
