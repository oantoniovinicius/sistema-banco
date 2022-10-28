import java.util.*;

public class Conta {
    private int numero;
    private String nome;
    private String cpf;
    private double saldo;
    private static int identificador=0;
    private ArrayList <Conta> contas = new ArrayList<Conta>();
    
    public Conta(){
        this.numero=0;
        this.saldo=0;
    }
    public Conta (String nome, String cpf, double saldo){
        this.nome=nome;
        this.cpf=cpf;
        this.numero=++identificador;
        this.saldo=0;
    }
 
  
    public void addConta(Conta conta){
        contas.add(conta);
    }
    
    public void sacar(double valor) {
        if (valor <= saldo && valor > 0){
            saldo -= valor;
        }
        else{
            throw new IllegalArgumentException("Valor de saque inválido");
        }
            
    }
    
    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
        }
        else{
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
    }
    public Conta pesquisarConta(int numero){
        Conta c=null;
        for (int i=0; i<contas.size(); i++){
            if (numero == contas.get(i).getNumero()){
                c=contas.get(i);
                break;
            }
        }
        return c;
    }
    public double imprimeSaldo(int numero){
        Conta c= pesquisarConta(numero);
        return c.consultarSaldo(numero);
    }
    public double consultarSaldo(int numero){
        return getSaldo();
    }
   
    public int getNumero() {
        return numero;
    }
    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
 
    public void setNumero(int numero) {
        this.numero = ++identificador;
    }
 
    public double getSaldo() {
        return this.saldo;
    }
    public ArrayList<Conta> getContas() {
		return contas;
	}
    

    public String toString(){
        return "Numero da conta: " + numero +
                "\nNome do cliente: " + nome +
                "\nCpf do cliente: " + cpf +
                "\nSaldo: " + saldo;
    }
}
