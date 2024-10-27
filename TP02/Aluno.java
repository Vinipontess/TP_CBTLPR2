import java.util.UUID;

public class Aluno {
    private String endereco;
    private int idade;
    private String nome;
    private UUID uuid;

    public Aluno(String endereco, int idade, String nome) {
        this.endereco = endereco;
        this.idade = idade;
        this.nome = nome;
        this.uuid = UUID.randomUUID(); // Gera um UUID único
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
