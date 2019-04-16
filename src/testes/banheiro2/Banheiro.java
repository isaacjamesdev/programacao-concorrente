package testes.banheiro2;

public class Banheiro {
	
	private boolean taSujo = true;
	
	public void fazNumero1() throws InterruptedException {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized(this) {
			System.out.println(nome + " entrando no banheiro");
			if(taSujo) {
				//Aqui ele vai sair desse bloco, e aguardar
				//até segunda ordem
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo coisa rapida");
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}
    }


    public void fazNumero2() throws InterruptedException {
    	String nome = Thread.currentThread().getName();
    	
    	System.out.println(nome + " batendo na porta");
    	
    	synchronized (this) {
    		System.out.println(nome + " entrando no banheiro");
    		if(taSujo) {
				//Aqui ele vai sair desse bloco, e aguardar
				//até segunda ordem
				esperaLaFora(nome);
			}
    		
    		System.out.println(nome + " fazendo coisa demorada");
    		try {
    			Thread.sleep(8000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		
    		System.out.println(nome + " dando descarga");
    		System.out.println(nome + " lavando a mao");
    		System.out.println(nome + " saindo do banheiro");			
		}
    	
    }
    
    public void limpaBanheiro(){
    	String nome = Thread.currentThread().getName();
    	System.out.println(nome + " batendo na porta");
    	System.out.println(nome + " entrando no banheiro");
    	synchronized(this) {
    		if(!taSujo) {
        		System.out.println(nome + " limpando banheiro");
            	try {
        			Thread.sleep(4000);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
            	this.taSujo = false;
        	}
        	System.out.println(nome + " saindo do banheiro");
        	this.notifyAll();
    	}
    	
    }
    
    private void esperaLaFora(String nome) throws InterruptedException {
		System.out.println(nome + " Eca! banheiro ta sujo");
		this.wait();
	}

}
