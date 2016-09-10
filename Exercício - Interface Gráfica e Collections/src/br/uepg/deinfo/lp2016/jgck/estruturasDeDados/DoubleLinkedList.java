package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;

import java.util.LinkedList;
import java.util.List;

public class DoubleLinkedList {
    private List <Integer> list = new LinkedList();
    
    public void insereLista(int pos, int valor){
        if(pos<list.size())
            list.add(pos, valor);
        else
            list.add(list.size(), valor);
    }
    
    public void removeLista(int pos){
        list.remove(0);
    }
    
    public boolean buscaLista(int valor)
    {
        return list.contains(valor);
    }
    
    public String toString()
    {
        
        // TODO fazer tratamento para vazia
        StringBuilder lista = new StringBuilder();
        for(Integer elemento : list)
        {
            lista.append((elemento.toString()+ " "));
        } 
         
        return lista.toString();
    }
}

