package com.java.brawl.sb.Utils;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.DataOutputStream;
import com.java.brawl.sb.Utils.Logger;

public class createMessage {

	private Logger console = new Logger();

	private int type, version;

	private byte[] payload, header;
	
	public createMessage(int a1, int a2, byte[] a3) {
		this.type = a1;
		this.version = a2;
		this.payload = a3;
		this.header = new byte[7];
	}

	public DataOutputStream write;

	public byte[] concat(byte[] a1, byte[] a2) {

		ByteBuffer buffer = ByteBuffer.wrap(new byte[a1.length + a2.length]);

		buffer.put(a1);
		buffer.put(a2);

		return buffer.array();
	}

	public void setHeader() {
		this.header[0] = (byte)(type >> 8 & 0xFF);
		this.header[1] = (byte)(type & 0xFF);

		int len = this.payload.length;

		this.header[2] = (byte)(len >> 16 & 0xFF);
		this.header[3] = (byte)(len >> 8 & 0xFF);

		this.header[4] = (byte)(len & 0xFF);

		this.header[5] = (byte)(version >> 8 & 0xFF);
		this.header[6] = (byte)(version & 0xFF);
	} 

	public void send(DataOutputStream Writer) {

		this.setHeader();

		byte[] packet = this.concat(this.header, this.payload);
		
		try {
			Writer.write(packet);
			console.color(
				"yellow",
				"[socket] message of type: " + type + " was sent."
			);
		} catch (IOException e) {}
	}
}