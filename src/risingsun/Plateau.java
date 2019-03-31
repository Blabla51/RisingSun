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
public class Plateau {
    
    public Node[] nodes; 

    public Plateau(Node[] nodes) {
        this.nodes = nodes;
    }
    
    public void updateOwner(Node[] n) {
        for (int i = 0; i < n.length; i++) {
            this.nodes[n[i].id].owner = n[i].owner; 
            this.nodes[n[i].id].qtCode = n[i].qtCode; 
            
            NeighborNode[] nn = this.nodes[n[i].id].neighbors; 
            for (int j = 0; j < nn.length; j++) {
                System.out.println(nn[j].debit);
                this.nodes[n[i].id].getNeighbor(nn[j].id).debit = n[i].neighbors[j].debit; 
            }
        }
    }
    
}
