package testes.lista;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroDaThread;
	
	public TarefaAdicionarElemento(Lista lista, int numeroDathread) {
		this.lista = lista;
		this.numeroDaThread = numeroDathread;
	}



	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			lista.adicionaElementos("Thread "+ numeroDaThread +" | "+ i);
		}

	}

}
