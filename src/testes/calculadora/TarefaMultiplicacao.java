package testes.calculadora;

import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaMultiplicacao implements Runnable{

	JTextField primeiro = new JTextField(10);
	JTextField segundo = new JTextField(10);
	JLabel resultado = new JLabel("           ?          ");

	public TarefaMultiplicacao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		super();
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	@Override
	public void run() {
		long valor1 = Long.parseLong(primeiro.getText());
		long valor2 = Long.parseLong(segundo.getText());
		BigInteger calculo = new BigInteger("0");
		
		for (int i = 0; i < valor1; i++) {
			for (int j = 0; j < valor2; j++) {
				calculo = calculo.add(new BigInteger("1"));
			}
		}

		resultado.setText(calculo.toString());
		
	}
	
	public void TarefaSemThread() {
		long valor1 = Long.parseLong(primeiro.getText());
		long valor2 = Long.parseLong(segundo.getText());
		BigInteger calculo = new BigInteger("0");
		
		for (int i = 0; i < valor1; i++) {
			for (int j = 0; j < valor2; j++) {
				calculo = calculo.add(new BigInteger("1"));
			}
		}

		resultado.setText(calculo.toString());
	}

}
