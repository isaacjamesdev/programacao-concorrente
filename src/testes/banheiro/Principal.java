package testes.banheiro;

public class Principal {
	 public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jefferson");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Bruno");
        Thread convidado3 = new Thread(new TarefaNumero2(banheiro), "Renan");

        convidado1.start();
        convidado2.start();
        convidado3.start();
    }

}
