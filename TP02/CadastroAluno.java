import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroAluno extends JFrame {
    private JTextField txtNome, txtIdade, txtEndereco;
    private List<Aluno> listaAlunos;

    public CadastroAluno() {
        listaAlunos = new ArrayList<>();
        setTitle("Cadastro de Alunos");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal com margem e centralização
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Margem de 20px ao redor
        add(mainPanel, BorderLayout.CENTER);

        // Painel superior com os campos de entrada
        JPanel painelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        painelSuperior.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelSuperior.add(txtNome);

        painelSuperior.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelSuperior.add(txtIdade);

        painelSuperior.add(new JLabel("endereco:"));
        txtEndereco = new JTextField();
        painelSuperior.add(txtEndereco);

        // Painel inferior com os botões
        JPanel painelInferior = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton btnOk = new JButton("OK");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");

        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        // Adicionando os painéis ao painel principal
        mainPanel.add(painelSuperior, BorderLayout.CENTER);
        mainPanel.add(painelInferior, BorderLayout.SOUTH);

        // Ações dos botões
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAlunos();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void cadastrarAluno() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String endereco = txtEndereco.getText();
            listaAlunos.add(new Aluno(endereco, idade, nome));
            limparCampos();
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
    }

    private void mostrarAlunos() {
        StringBuilder mensagem = new StringBuilder("Resultado\n");
        for (Aluno aluno : listaAlunos) {
            mensagem.append("Id: ").append(aluno.getUuid())
                    .append(" Nome: ").append(aluno.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensagem.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAluno cadastro = new CadastroAluno();
            cadastro.setVisible(true);
        });
    }
}
