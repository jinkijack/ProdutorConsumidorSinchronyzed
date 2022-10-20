public class CubbyHole {
	private int content;
	private boolean algoParaConsumir = false;
	
	public void set(int producer, int value) {
			if(algoParaConsumir){
				try {
					wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			content = value;
			System.out.printf("Produtor %d produziu %d\n",producer,value);
			algoParaConsumir=true;
			notify();
		//... codigo nao sincronizado aqui
	}
	
	public int get(int consumer) {
		if(!algoParaConsumir){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.err.printf("Consumidor %d consumiu %d\n",consumer,content);
		algoParaConsumir=false;
		notify();
		return content;
	}


}