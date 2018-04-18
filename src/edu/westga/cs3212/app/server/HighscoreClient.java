package edu.westga.cs3212.app.server;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class HighscoreClient {
	private String score;
	private String codedScoreboard;

	public HighscoreClient(int Score) {
		Context context = ZMQ.context(1);
		this.score = String.valueOf(Score);

		System.out.println("Connecting to hello world server");

		Socket socket = context.socket(ZMQ.REQ);
		socket.connect("tcp://127.0.0.1:5555");

		String request = "highscore";
		System.out.println("Client - Sending Highscore");
		socket.send(request.getBytes(ZMQ.CHARSET), 0);
		
		
		byte[] reply = socket.recv(0);
		String response = new String(reply, ZMQ.CHARSET);
		System.out.println("Client - Received " + response);

		System.out.println(this.score.getBytes(ZMQ.CHARSET));
		socket.send(this.score.getBytes(ZMQ.CHARSET),0);
		System.out.println("Client - Sent " + this.score);
		
		reply = socket.recv(0);
		response = new String(reply, ZMQ.CHARSET);
		codedScoreboard = response;
		System.out.println("Client - Received " + response);

		request = "exit";
		System.out.println("Client - Sending exit");
		socket.send(request.getBytes(ZMQ.CHARSET), 0);

		socket.close();
		context.term();
	}
	
	public String getScoreboardString()
	{
		return codedScoreboard;
	}
}
