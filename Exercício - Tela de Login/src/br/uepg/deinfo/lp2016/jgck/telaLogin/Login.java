package br.uepg.deinfo.lp2016.jgck.telaLogin;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private JLabel labelLogin, labelPwd;
    private JTextField loginField;
    private JPasswordField pwdField;
    private JButton okButton, cancelButton;
    private Handler handler = new Handler();

    // O certo é fazer uma conexão com banco de dados, mas para simplificar o conceito fiz assim
    private String usuario = "xampso";
    private String senha = "senha";
    private String errorMessage;

    private void constroiJanela() {
        //Pega tamanho da tela
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        // ----------- CAMPOS -----------
        //Instancia texto label para login
        labelLogin = new JLabel("Login: ");
        //Adiciona o JLabel na interface gráfica
        add(labelLogin);

        //Instancia campo de login 
        loginField = new JTextField(20);
        //Diz que o handler pode lidar com os eventos gerados por login
        loginField.addActionListener(handler);
        //Adiciona campo senha na interface
        add(loginField);

        //Instancia texto label para senha
        labelLogin = new JLabel("Password: ");
        //Adiciona o JLabel na interface gráfica
        add(labelLogin);

        //Instancia campo senha 
        pwdField = new JPasswordField(20);
        //Diz que o handler pode lidar com os eventos gerados por senha
        pwdField.addActionListener(handler);
        //Adiciona campo senha na interface
        add(pwdField);

        //Instancia botão de ok
        okButton = new JButton("OK");
        //Diz que o handler pode lidar com os eventos gerados pelo botão de ok
        okButton.addActionListener(handler);
        //Adiciona botão na interface
        add(okButton);

        //Instancia botão de cancelar
        cancelButton = new JButton("Cancelar");
        //Diz que o handler pode lidar com os eventos gerados pelo botão de ok
        cancelButton.addActionListener(handler);
        //Adiciona botão na interface
        add(cancelButton);

        // ----------- CONFIGURAÇÕES DA JANELA -----------
        //Define tamanho da tela
        setSize(width / 2, height / 2);
        //Define Layout da janela
        setLayout(new FlowLayout());
        //Define tela como visível
        setVisible(true);
        //Habilita fechar no X(canto superior direito)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Login() {
        //Chama construtor da classe JFrame
        super("Login");
        //Constroi a Janela principal
        constroiJanela();
    }

    //Captura os eventos gerados pela tela
    private class Handler implements ActionListener {

        //Captura evento, é obrigatório implementar devido a interface ActionListener
        @Override
        public void actionPerformed(ActionEvent e) {
            Object field = e.getSource();

            if (field == loginField || field == pwdField || field == okButton) {
                if (verificaCampos()) {
                    if (efetuarLogin()) {
                        JOptionPane.showMessageDialog(rootPane, "Login efetuado");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, errorMessage);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, errorMessage);
                }
            }
            if (field == cancelButton) {
                System.exit(0);
            }
        }
    }

    private boolean verificaCampos() {
        if ("".equals(loginField.getText()) || null == loginField.getText()) {
            errorMessage = "Digite um usuário";
            return false;
        } else if ("".equals(new String(pwdField.getPassword())) || null == new String(pwdField.getPassword())) {
            errorMessage = "Digite uma senha";
            return false;
        } else {
            return true;
        }
    }

    private boolean efetuarLogin() {
        if (usuario.equals(loginField.getText())) {
            if (senha.equals(new String(pwdField.getPassword()))) 
                return true;
            else{
                errorMessage="Senha errada";
                return false;
            }
        }
        else
        {
                errorMessage="Usuário inválido";
                return false;
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}