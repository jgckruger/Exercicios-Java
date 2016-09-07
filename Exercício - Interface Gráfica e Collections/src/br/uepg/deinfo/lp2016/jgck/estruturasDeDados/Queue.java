package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;

import java.util.LinkedList;
import java.util.List;

public class Queue {
    private List <Integer> queue = new LinkedList();
    
    public void insereFila(int valor){
        queue.add(queue.size(), valor);
    }
    
    public void removeFila(){
        queue.remove(0);
    }
    
    public int topoFila()
    {
        return queue.get(0);
    }
}

