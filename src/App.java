import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class App {
  public static void main(String[] args) {
    // Identidade/Entidade/Objetos de Valor (Value Objects)
    // Entidades têm campos chave

    Conta c5 = new Conta(111, 22222);
    c5.carregar();
    c5.depositar(1000);
    System.out.println(c5.getSaldo()); // 1225
    
    Conta c6 = new Conta(111, 22222);
    c6.carregar();
    c6.sacar(100);
    System.out.println(c6.getSaldo()); // 125

    // c5.salvar();
    // c6.salvar();
    // não têm a mesma identidade,
    System.out.println(c5 == c6); // false

    System.out.println(c5.equals(c6)); // true!
    // elas são a mesma entidade?

    Set<Conta> contas = new HashSet<>();
    contas.add(c5); // true
    contas.add(c6); // false
    System.out.println(contas); // ? [c5]

    double x = 123.232;
    int i = (int) x; // cast/coerção


    // Entidade: campo(s) chave, ex: CPF
    Cliente c1 = new Cliente("12345678901", "Marcio");
    Cliente c2 = new Cliente("12345678901", "Marcio Torres");
    System.out.println(c1.equals(c2)); // TRUE


    // Conta c1 = new Conta(123, 4567888);
    // transiente/transitório (Memória RAM)
    // System.out.println(c1.getSaldo()); // 0
    
    // c1.carregar();
    
    // System.out.println(c1.getSaldo()); // ?

    // c1.depositar(12);
    // c1.sacar(5);
    // c1.depositar(5);
    // c1.sacar(5);
    // System.out.println(c1.getSaldo()); // 7
    // persistente
    // c1.salvar(); // armazenar num BD
    
    // Conta c2 = new Conta(123, 4567);
    // c2.depositar(10);
    // c2.depositar(10);
    // c2.depositar(10);
    // System.out.println(c2.getSaldo()); // 30
    


  }  
}
