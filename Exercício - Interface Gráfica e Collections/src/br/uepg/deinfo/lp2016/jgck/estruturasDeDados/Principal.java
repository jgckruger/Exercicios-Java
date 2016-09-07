package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame {

    private JMenuBar menuBar;
    private JMenu dataStructures;
    private JMenuItem stackMenu;
    private JMenuItem queueMenu;
    private JMenuItem exitMenu;
    private JPanel displayPanel;
    private JButton addButton, removeButton, printButton;
    private JTextField addField, removeField;
    private JTextArea displayTextArea;
    private Queue queue;
    private Stack stack;
    private String currentDataStructure="stack";
    private ActionHandler actionHandler;
    

    private void desenhaJanela() {
        this.setLayout(new BorderLayout(5, 5));
        
        
        menuBar = new JMenuBar();
        dataStructures = new JMenu("Estruturas");
        stackMenu = new JMenuItem("Pilha");
        queueMenu = new JMenuItem("Fila");
        exitMenu = new JMenuItem("Sair");
        menuBar.add(dataStructures);
        dataStructures.add(stackMenu);
        dataStructures.add(queueMenu);
        dataStructures.add(exitMenu);
        this.setJMenuBar(menuBar);

        
        
        displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout());

        
        
        addButton = new JButton("Adicionar");
        addButton.addActionListener(actionHandler);
        displayPanel.add(addButton);
        
        addField = new JTextField(10);
        addField.addActionListener(actionHandler);
        displayPanel.add(addField);
        
        
        removeButton = new JButton("Remover");
        removeButton.addActionListener(actionHandler);
        displayPanel.add(removeButton);
        
        removeField = new JTextField(10);
        removeField.addActionListener(actionHandler);
        removeField.setVisible(false);
        displayPanel.add(removeField);
        
        
        printButton = new JButton("Imprimir");
        printButton.addActionListener(actionHandler);
        displayPanel.add(printButton);
        
        
        
        displayTextArea = new JTextArea(4,1);
        displayTextArea.setEditable(false);
        this.add(displayTextArea, BorderLayout.SOUTH);
        

        
        this.add(displayPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);

    }

    public Principal() {
        super("Estruturas");
        actionHandler = new ActionHandler();
        desenhaJanela();
    }
    
    private class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object field = ae.getSource();
            
            if(currentDataStructure=="stack")
            {
                if(stack==null)
                    stack=new Stack();
                if((field==addButton || field == addField)&& !"".equals(addField.getText()))
                    stack.push(Integer.parseInt(addField.getText()));
                else if(field==removeButton)
                        stack.pop();
                else if(field==printButton)
                    displayTextArea.setText("O topo da pilha é: "+ stack.topoPilha());
            }
        }
        
    }

    public static void main(String[] args) {
        new Principal();
    }

}
