package testes.banheiro2;

public class Principal {
	 public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jefferson");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Bruno");
        Thread limpeza = new Thread(new LimpaBanheiro(banheiro), "Limpeza");

        convidado1.start();
        convidado2.start();
        limpeza.start();
    }

}
