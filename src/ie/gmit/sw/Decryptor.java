package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Decryptor implements Runnable {
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
	}

	public void run(){
		//get score for the given key and put everything in a Resultable r = new Result(plaintext, key, score)
		try {
				Resultable r = null; // this line just here so queue.put(r) isnt an error
				queue.put(r);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}