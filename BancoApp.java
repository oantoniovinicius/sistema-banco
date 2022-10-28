import javax.swing.JOptionPane;

public class BancoApp {
    public static String menu(){
        return "Digite:\n" +
                "1 - Criar conta \n" +
                "2 - Depositar \n"+
                "3 - Sacar \n"+
                "4 - Consultar saldo\n"+
                "5 - Imprimir conta\n"+
                "0 - para sair";
    }
    public static void main(String[] args) {
        int op=0;
        Conta cc= new Conta();

        op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

        while(op!=0){
            switch(op){
                case 1->{
                    double saldo=0;
                    String nome= JOptionPane.showInputDialog("Informe o nome do cliente: ");
                    String cpf= JOptionPane.showInputDialog("Informe o cpf do cliente: ");
                    Conta conta= new Conta(nome, cpf, saldo);
                    cc.addConta(conta);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\n" + 
                    conta.toString());
                }
                
                case 2->{
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da conta: "));
                    Conta pConta = cc.pesquisarConta(numero);
                    if(pConta==null){
                        JOptionPane.showMessageDialog(null, "Erro!\n"+ 
                        "Conta não encontrada. Tente novamente. ");
                    }
                    else{
                        try{
                            double valor= Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito: "));
                            cc.getContas().get(numero-1).depositar(valor);
                            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso" + 
                            "\nNovo saldo: " + cc.imprimeSaldo(numero));
                        }
                        catch (IllegalArgumentException e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }

                case 3->{
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da conta: "));
                    Conta pConta = cc.pesquisarConta(numero);
                    if(pConta==null){
                        JOptionPane.showMessageDialog(null, "Erro!\n"+ 
                        "Conta não encontrada. Tente novamente. ");
                    }
                    else{
                        try{
                            double valor= Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque: "));
                            cc.getContas().get(numero-1).sacar(valor);
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso" + 
                            "\nNovo saldo: " + cc.imprimeSaldo(numero));                
                        }
                        catch (IllegalArgumentException e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }

                case 4->{
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da conta: "));
                    Conta pConta = cc.pesquisarConta(numero);
                    if(pConta==null){
                        JOptionPane.showMessageDialog(null, "Erro!\n"+ 
                        "Conta não encontrada. Tente novamente. ");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Conta: "+ numero+"\nSaldo: "+cc.imprimeSaldo(numero));
                    }
                }

                case 5-> {
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da conta: "));
                    Conta pConta = cc.pesquisarConta(numero);
                    if(pConta==null){
                        JOptionPane.showMessageDialog(null, "Erro!\n"+ 
                        "Conta não encontrada. Tente novamente. ");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, cc.getContas().toString());
                    }
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }
}

