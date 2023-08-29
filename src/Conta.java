import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

class Conta {

  private final int agencia;
  private final int numero;

  // Lista
  private List<Integer> lancamentos = new ArrayList<>();

  Conta(int agencia, int numero) {
    this.agencia = agencia;
    this.numero = numero;
  }

  int getAgencia() {
    return agencia;
  }

  int getNumero() {
    return numero;
  }

  void depositar(int valor) {
    if (valor > 0) {
      this.lancamentos.add(valor);
    }
  }

  void sacar(int valor) {
    if (valor > 0) {
      this.lancamentos.add(-valor);
    }
  }

  // maneira moderna (funcional)
  int getSaldo() {
    return lancamentos.stream().reduce(0, Integer::sum);
  }

  void salvar() { // ./bd/1234-56788.log
    Path arq = Paths.get(".", "bd", agencia + "-" + numero + ".log");
    try {
      Files.write(
        arq,
        lancamentos.stream()
              .map(String::valueOf)//.toList()
              .collect(Collectors.toList()),
        StandardOpenOption.CREATE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void carregar() {
    Path arq = Paths.get(".", "bd", agencia + "-" + numero + ".log");
    try {
      Files.readAllLines(arq).stream() // List<String>
          .map(Integer::valueOf) // List<Integer>
          .forEach(lancamentos::add);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // maneira tradicional (for each)
  // int getSaldo() {
  //   int saldo = 0;
  //   // for each => para cada valor de lancamentos
  //   for (Integer valor : lancamentos) {
  //     saldo += valor;
  //   }
  //   return saldo;
  // }

  // modo vintage (for i)
  // int getSaldo() {
  //   int saldo = 0;
  //   for (int i = 0; i < lancamentos.size(); i++) {
  //     saldo += lancamentos.get(i);
  //   }
  //   return saldo;
  // }

  public int hashCode() {
    // código para o objeto // 1234
    // 123400000
    // 123478902
    return this.agencia * 10000 + this.numero;
  }

  @Override // sinaliza que estamos sobrescrevendo (opcional)
  public boolean equals(Object o) { //
    // if (this == o) return true; // é reflexivo
    // if (o == null) return false;

    if (o instanceof Conta) { // "o" é uma Conta?
      Conta outra = (Conta) o;
      return this.numero == outra.numero &&
             this.agencia == outra.agencia;
    }

    return false;
  }
}
