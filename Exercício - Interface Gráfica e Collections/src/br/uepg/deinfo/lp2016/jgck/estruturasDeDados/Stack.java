package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private List <Integer> stack = new LinkedList();
    
    public void push(int valor){
        stack.add(0,valor);
    }
    
    public void pop(){
        stack.remove(0);
    }
    
    public int topoPilha()
    {
        return stack.get(0);
    }
}
