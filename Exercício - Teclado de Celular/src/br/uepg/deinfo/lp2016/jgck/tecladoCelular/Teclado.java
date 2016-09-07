package br.uepg.deinfo.lp2016.jgck.tecladoCelular;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Teclado extends JFrame {

    private JButton numericButtons[];
    private JPanel resultPanel;
    private JButton clearButton;
    private JTextField textField;
    private StringBuilder textFieldContent;
    private Handler handler = new Handler();

    public Teclado() {
        super("Teclado");
        desenhaJanela();
    }

    public static void main(String args[]) {
        new Teclado();
    }

    private class Handler implements ActionListener {

        //Captura evento
        @Override
        public void actionPerformed(ActionEvent e) {
            Object field = e.getSource();

            if (field instanceof JButton) {
                if (field != clearButton) { // É BOTÃO DE TECLA, DÁ PUSH
                    textFieldContent.append(e.getActionCommand());
                    textField.setText(textFieldContent.toString());
                } else { // É BOTÃO DE LIMPAR, ZERA STRING
                    textFieldContent.delete(0, textFieldContent.length());
                    textField.setText("");
                }
            }

        }
    }

    private void desenhaJanela() {

        // CONTAINER (BORDER) PRINCIPAL
        setLayout(new BorderLayout(10, 10));

        // CONTAINER (GRID) DAS TECLAS
        JPanel teclas = new JPanel();
        teclas.setLayout(new GridLayout(4, 3, 10, 10)); // LINHAS, COLUNAS, DISTANCIA EM PIXELS ENTRE COMPONENTES

        // BOTÕES DO TECLADO
        numericButtons = new JButton[12];
        for (int i = 1; i < 10; i++) {
            numericButtons[i - 1] = new JButton(String.valueOf(i));
        }
        numericButtons[9] = new JButton("#");
        numericButtons[10] = new JButton("0");
        numericButtons[11] = new JButton("*");
        for (JButton botao : numericButtons) {
            botao.addActionListener(handler);
            teclas.add(botao);
        }

        // CONTAINER (BORDER) DO PAINEL DE RESULTADOS
        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout(10, 10));

        // BOTÃO DO PAINEL DE RESULTADOS
        clearButton = new JButton("LIMPAR");
        resultPanel.add(clearButton, BorderLayout.NORTH);
        clearButton.addActionListener(handler);

        // VISOR DO PAINEL DE RESULTADOS
        textFieldContent=new StringBuilder();
        textField = new JTextField("asd");
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("arial", Font.PLAIN, 26));
        resultPanel.add(textField, BorderLayout.SOUTH);

        // INSERINDO PAINÉIS NO CONTAINER PRINCIPAL
        add(teclas, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // MÉTODOS OBRIGATÓRIOS
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
        validate();

    }

}
