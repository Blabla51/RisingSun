/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import java.util.ArrayList;
import static risingsun.GameServer.*;

/**
 *
 * @author Charon
 */
public class PlyPlay2 {

    public Player p;

    public PlyPlay2(Player p) {
        this.p = p;
    }

    public void play(Node[] AllNodes, Node[] VisibleNodes) throws Exception {
        int[] idVis = new int[AllNodes.length];
        int[] owners = new int[AllNodes.length];
        ArrayList<Node> controlledNodes = new ArrayList<>();
        boolean[] isVisible = new boolean[AllNodes.length];
        for (int i = 0; i < AllNodes.length; i++) {
            isVisible[i] = false;
            for (int j = 0; j < VisibleNodes.length; j++) {
                if (VisibleNodes[j].id == AllNodes[i].id) {
                    isVisible[i] = true;
                    idVis[i] = j;
                    if (VisibleNodes[j].owner == p.id) {controlledNodes.add(VisibleNodes[j]);}
                    break;
                }
            }
            if (!isVisible[i]) {
                idVis[i] = -2;
            }
            owners[i] = AllNodes[i].owner;
        }
        for (int i = 0 ; i < AllNodes.length ; i++) {
            if (isVisible[i]) {
                AllNodes[i].qtCode = VisibleNodes[idVis[i]].qtCode;
            }
        }
        boolean hasEnnemyAround;
        ArrayList<Node> noEnnemies = new ArrayList<>();
        for (Node N : controlledNodes) {
            hasEnnemyAround = false;
            for (NeighborNode V : N.neighbors) {
                if (owners[V.id] != p.id && N.qtCode > AllNodes[V.id].qtCode) {
                    hasEnnemyAround = true;
                    N.qtCode -= AllNodes[V.id].qtCode;
                    Action A = new Action(this.p.id, N.id, V.id, Math.min(V.debit, AllNodes[V.id].qtCode + 1));
                    Action[] Actions = {A};
                    playAction(this.p, Actions);
                }
            }
            if (!hasEnnemyAround) {
                noEnnemies.add(N);
            } else {
                N.needHelp = true;
            }
        }
        for (Node N : noEnnemies) {
            ArrayList<Node> needingHelp = new ArrayList<>();
            for (NeighborNode V : N.neighbors) {
                if (AllNodes[V.id].needHelp) {
                    needingHelp.add(AllNodes[V.id]);
                    AllNodes[V.id].debitUU = V.debit;
                }
            }
            if (needingHelp.size() > 0) {
                int sommeCodes = 0;
                for (Node V : needingHelp) {
                    sommeCodes += V.qtCode;
                }
                for (Node V : needingHelp) {
                    Action A = new Action(this.p.id, N.id, V.id, Math.min(V.debitUU, ((sommeCodes - V.qtCode) * N.qtCode) / sommeCodes));
                    Action[] Actions = {A};
                    playAction(this.p, Actions);
                }
            } else {
                int sommeCodes = 0;
                for (NeighborNode V : N.neighbors) {
                    sommeCodes += AllNodes[V.id].qtCode;
                }
                for (NeighborNode V : N.neighbors) {
                    Action A = new Action(this.p.id, N.id, V.id, Math.min(V.debit, ((sommeCodes - AllNodes[V.id].qtCode) * N.qtCode) / sommeCodes));
                    Action[] Actions = {A};
                    playAction(this.p, Actions);
                }
            }
            
        }
    }
    
    public int distanceToEnnemy(Node N, Node[] AllNodes, Node[] VisibleNodes, int[] owners, int[] idVis, boolean[] visited) {
        if (N.owner == p.id) {
            int min = AllNodes.length;
            for (int i = 0 ; i < N.neighbors.length ; i++) {
                if (!visited[N.id]) {
                    visited[N.id] = true;
                    min = Math.min(min, 1 + distanceToEnnemy(AllNodes[N.neighbors[i].id], AllNodes, VisibleNodes, owners, idVis, visited));
                }
            }
            return min;
        } else {
            return 0;
        }
    }

}
