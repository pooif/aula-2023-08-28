
public class Cliente {

  private final String cpf;
  private String nome;

  Cliente(String cpf, String nome) {
    this.cpf = cpf;
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cliente) {
      Cliente outro = (Cliente) o;
      return this.cpf.equals(outro.cpf); 
    }
    return false;
  }

}
