package PHashService;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Map;

import IBRService.IBR;
import IBRService.ImageDescriptor;

public class ImageHasher implements Runnable {

	String url;
	SocketChannel sc;

	public ImageHasher(SocketChannel sc, String url) {
		this.url = url;
		this.sc = sc;
	}

	public void run() {
		try {
			System.out.println("URL over the net " + url);
			Map.Entry<IBR, ImageDescriptor> entry = IBR.getIBRFromFile(url);

			// Hash Image then close socket channel
			ByteBuffer bb = ByteBuffer.allocate(entry.getKey().toString().length());
			bb.put(entry.getKey().toString().getBytes());
			bb.rewind();
			// bb.put(entry.getKey().getIbr());
			sc.write(bb);
			System.out.println("IBR " + entry.getKey().toString());
			sc.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
