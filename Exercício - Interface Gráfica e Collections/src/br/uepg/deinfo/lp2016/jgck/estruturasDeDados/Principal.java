package br.uepg.deinfo.lp2016.jgck.estruturasDeDados;


import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame {

    private JMenuBar menuBar;
    
    private JMenu dataStructures;
    
    private JMenuItem stackMenu;
    private JMenuItem queueMenu;
    private JMenuItem listMenu;
    private JMenuItem treeMenu;
    
    private JMenuItem exitMenu;
    private JPanel displayPanel;
    private JButton addButton, removeButton, printButton, searchButton;
    private JTextField addField, removeField, searchField;
    private JTextArea displayTextArea;
    private Queue queue;
    private Stack stack;
    private DoubleLinkedList list;
    private BinarySearchTree tree;
    
    private String currentDataStructure="stack";
    private ActionHandler actionHandler;
    

    private void desenhaJanela() {
        this.setLayout(new BorderLayout(5, 5));
        
        
        menuBar = new JMenuBar();
        dataStructures = new JMenu("Estruturas");
        stackMenu = new JMenuItem("Pilha");
        stackMenu.addActionListener(actionHandler);
        queueMenu = new JMenuItem("Fila");
        queueMenu.addActionListener(actionHandler);
        listMenu = new JMenuItem("Lista");
        listMenu.addActionListener(actionHandler);
        treeMenu = new JMenuItem("Árvore");
        treeMenu.addActionListener(actionHandler);
        exitMenu = new JMenuItem("Sair");
        exitMenu.addActionListener(actionHandler);
        menuBar.add(dataStructures);
        dataStructures.add(stackMenu);
        dataStructures.add(queueMenu);
        dataStructures.add(listMenu);
        dataStructures.add(treeMenu);
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
        
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(actionHandler);
        searchButton.setVisible(false);
        displayPanel.add(searchButton);
        
        searchField = new JTextField(10);
        searchField.addActionListener(actionHandler);
        searchField.setVisible(false);
        displayPanel.add(searchField);
        
        
        
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
        // TODO TRATAMENTO DE ERROS COM TRY/CATCH
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            Object field = ae.getSource();
            if(field==exitMenu)
                System.exit(0);
            if(field==stackMenu){
                currentDataStructure="stack";
                removeField.setVisible(false);
                searchField.setVisible(false);
                searchButton.setVisible(false);
                validate();
            }
            if(field==queueMenu){
                currentDataStructure="queue";
                removeField.setVisible(false);
                searchField.setVisible(false);
                searchButton.setVisible(false);
                validate();
            }
            if(field==listMenu){
                currentDataStructure="list";
                removeField.setVisible(true);
                searchField.setVisible(true);
                searchButton.setVisible(true);
                validate();
            }
            if(field==treeMenu){
                currentDataStructure="tree";
                removeField.setVisible(true);
                searchField.setVisible(true);
                searchButton.setVisible(true);
                validate();
            }
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
            if(currentDataStructure=="queue")
            {
                if(queue==null)
                    queue=new Queue();
                if((field==addButton || field == addField)&& !"".equals(addField.getText()))
                    queue.insereFila(Integer.parseInt(addField.getText()));
                else if(field==removeButton)
                        queue.removeFila();
                else if(field==printButton)
                    displayTextArea.setText("O topo da fila é: "+ queue.topoFila());
            }
            if(currentDataStructure=="list")
            {
                if(list==null)
                    list=new DoubleLinkedList();
                if((field==addButton || field == addField)&& !"".equals(addField.getText())){
                    int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe uma posição para inserir na lista", "Informe uma posição", JOptionPane.PLAIN_MESSAGE));
                    list.insereLista(pos, Integer.parseInt(addField.getText()));
                }
                else if((field==removeButton || field == removeField)&& !"".equals(removeField.getText())){//(field==removeButton){
                        list.removeLista(Integer.parseInt(removeField.getText()));
                }
                else if((field==searchButton || field == searchField)&& !"".equals(searchButton.getText())){//(field==removeButton){
                        list.buscaLista(Integer.parseInt(searchField.getText()));
                }
                else if(field==printButton){
                    displayTextArea.setText("Lista:\n"+ list.toString());
                }
            }
            if(currentDataStructure=="tree")
            {
                if(tree==null)
                    tree=new BinarySearchTree();
                
                if((field==addButton || field == addField)&& !"".equals(addField.getText())){
                    tree.insereArvore(Integer.parseInt(addField.getText()));
                }
                else if(field==removeButton){
                    tree.removeArvore(Integer.parseInt(addField.getText()));
                }
                else if(field==printButton){
                    displayTextArea.setText("Percurso em ordem:\n"+ tree.toString());
                }
                
            }
        }
        
    }

    public static void main(String[] args) {
        new Principal();
    }

}
