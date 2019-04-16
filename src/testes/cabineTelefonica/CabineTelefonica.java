package testes.cabineTelefonica;

import java.util.concurrent.Semaphore;

public class CabineTelefonica  extends Thread{
	private String nome;
    private Semaphore semaforo;
 
    public CabineTelefonica(String nome, Semaphore semaphore) {
        this.nome = nome;
        this.semaforo = semaphore;
    }
    
    //Rodar as tarefas
    private void aguardando() {
        try {
            System.out.println(nome + " aguardando na fila");
            Thread.sleep((long) (Math.random() * 12000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void telefonando() {
        try {
            System.out.println(nome + " telefonando");
            Thread.sleep((long) (Math.random() * 10000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void entrarRegiaoNaoCritica() {
        System.out.println(nome + " entrou na fila");
        aguardando();
    }
    
    private void entrarRegiaoCritica() {
        System.out.println(nome
                + " entrou na cabine");
        telefonando();
        System.out.println(nome + " saiu da cabine");
    }
    
    @Override
    public void run() {
    	entrarRegiaoNaoCritica();
        try {
            semaforo.acquire();
            entrarRegiaoCritica();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
    
}
