import java.util.Scanner;

public class ContaDoBanco {

    Scanner ler = new Scanner(System.in);
    private int numConta;
    private String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    // Inicializa a conta fechada e sem saldo
    public ContaDoBanco(){
        this.saldo = 0;
        this.status = false;
    }

    // Getters e setters para controle de acesso aos atributos
    public int getNumConta(){
        return this.numConta;
    }

    public void setNumConta(int n){
        this.numConta = n;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String t){
        this.tipo = t;
    }

    public String getDono(){
        return this.dono;
    }

    public void setDono(String d){
        this.dono = d;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double s){
        this.saldo = s;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean st){
        this.status = st;
    }

    // Realiza a abertura da conta e define saldo inicial conforme o tipo
    public void abrirConta(){
        System.out.print("Primeiramente, qual o seu nome: ");
        setDono(ler.nextLine());

        System.out.print("Qual o tipo de conta que você deseja abrir? Conta Corrente(CC) ou Conta Poupança (CP): ");
        setTipo(ler.nextLine());

        setStatus(true);

        if (getTipo().equalsIgnoreCase("CC")){
            setSaldo(50);
        }
        else if (getTipo().equalsIgnoreCase("CP")) {
            setSaldo(150);
        }
        else {
            System.out.println("Tipo de conta inválida");
        }
    }

    // Fecha a conta apenas se não houver saldo
    public void fecharConta(){
        if (this.saldo > 0) {
            System.out.println("Existe saldo na conta, ela não pode ser fechada");
        }
        else{
            setStatus(false);
        }
    }

    // Adiciona valor ao saldo caso a conta esteja ativa
    public void depositar(){
        if (getStatus()){
            Scanner ler = new Scanner(System.in);
            double adicionar = ler.nextDouble();
            setSaldo(getSaldo() + adicionar);
        }
        else{
            System.out.println("Por favor, abra uma conta");
        }
    }

    // Realiza saque respeitando o saldo disponível
    public void sacar(){
        if (getStatus()){
            double retirar = ler.nextDouble();
            if (getSaldo() >= retirar){
                setSaldo(getSaldo() - retirar);
            }
            else {
                System.out.println("Saldo insuficiente para retirada");
            }
        }
        else{
            System.out.println("Por favor, abra uma conta");
        }
    }

    // Debita a mensalidade conforme o tipo da conta
    public void pagarMensalidade(){
        if (getStatus()){
            if (getTipo().equalsIgnoreCase("CC")){
                setSaldo(getSaldo() - 12);
            }
            else if (getTipo().equalsIgnoreCase("CP")){
                setSaldo(getSaldo() - 20);
            }
        }
        else {
            System.out.println("Abra uma conta antes de pagar a mensalidade");
        }
    }

    // Exibe informações relevantes da conta
    public void status(){
        if(getStatus()){
            System.out.println("A CONTA PERTENCE A: " + getDono());
            System.out.println("O TIPO DE CONTA ABERTA: " + getTipo());
            System.out.println("O SALDO DA CONTA: " + getSaldo());
        }
        else {
            System.out.println("Crie uma conta primeiramente");
        }
    }
}
