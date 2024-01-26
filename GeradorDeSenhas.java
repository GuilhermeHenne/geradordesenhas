import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class GeradorDeSenhas extends JFrame {

    private JTextField comprimentoField;
    private JTextArea senhaArea;

   



    public GeradorDeSenhas() {
        setTitle("Gerador de Senhas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JOptionPane.showMessageDialog(null, "Aqui você irá gerar uma senha aleatória.", "Gerador de Senhas", JOptionPane.INFORMATION_MESSAGE);


        initComponents();
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);

        JLabel labelComprimento = new JLabel("Comprimento da Senha:");
        comprimentoField = new JTextField();
        JLabel labelSenha = new JLabel("Senha Gerada:");
        senhaArea = new JTextArea();
        senhaArea.setEditable(false);
        JButton btnGerarSenha = new JButton("Gerar Senha");

        //tamanho
        comprimentoField.setPreferredSize(new Dimension(100, 30));
        senhaArea.setPreferredSize(new Dimension(200, 30));
        btnGerarSenha.setPreferredSize(new Dimension(120, 30));

        btnGerarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarSenha();
            }
        });

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelComprimento)
                                .addComponent(labelSenha))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(comprimentoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(senhaArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGerarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE)));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelComprimento)
                                .addComponent(comprimentoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGerarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSenha)
                                .addComponent(senhaArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE)));

        pack();
    }

    private void gerarSenha() {
        try {
            int comprimento = Integer.parseInt(comprimentoField.getText());
            String senhaGerada = gerarSenha(comprimento);
            senhaArea.setText(senhaGerada);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido para o comprimento da senha.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String gerarSenha(int comprimento) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GeradorDeSenhas().setVisible(true);
            }
        });
    }
}
