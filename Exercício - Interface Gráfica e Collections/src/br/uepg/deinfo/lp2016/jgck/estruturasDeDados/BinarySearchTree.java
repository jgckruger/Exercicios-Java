/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;


import java.util.TreeSet;
import java.lang.Integer;

/**
 *
 * @author deinfo
 */
public class BinarySearchTree {
     private TreeSet <Integer> tree = new TreeSet();

    public void insereArvore(int valor)
    {
        tree.add(valor);
    }
    
    public void removeArvore(int valor)
    {
        tree.remove(valor);
    }
    
    public String toString()
    {
        
        // TODO fazer tratamento para vazia
        StringBuilder bstree = new StringBuilder();
        for(Integer elemento : tree)
        {
            bstree.append((elemento.toString()+ " "));
        } 
         
        return bstree.toString();
    }
    
}
