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
    }
    @Override public String toString(){
        String s = "";
        s += "Node : \n id = " + id + "\n x = " + coordX + "\n y = " + coordY + "\n" + "production : " + production + "qtCode = " + qtCode;
        for (int i = 0; i < neighbors.length; i++) {
            s += "Neighbors id : " + neighbors[i].id + "\n";
        }
        s += "owner = " + owner + "\n";
        return s;
    }
    
    
    
}
