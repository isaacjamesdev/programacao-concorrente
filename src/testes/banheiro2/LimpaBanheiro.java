package testes.banheiro2;

public class LimpaBanheiro implements Runnable{
	private Banheiro banheiro;

    public LimpaBanheiro(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.limpaBanheiro();
    }

}
