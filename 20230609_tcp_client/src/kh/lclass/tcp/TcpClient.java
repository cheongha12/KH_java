package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {

	public void testTcpClient(String ip, int port) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pr = null;

		Scanner Sc = new Scanner(System.in);
		// Scanner와 유사한 기능
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		try {
			socket = new Socket(ip, port);
			System.out.println("서버에 접속 성공");

			in = socket.getInputStream();
			out = socket.getOutputStream();

			br = new BufferedReader(new InputStreamReader(in));
			pr = new PrintWriter(new OutputStreamWriter(out));

			// String receivedMsg =br.readLine();
			// System.out.println("받은 메시지:"+ receivedMsg);
			String sendMsg = null;
			while (true) {

				System.out.println("메시지>>");
				sendMsg = stdIn.readLine(); // console에 입력한 문자 읽어들이기 위한 객체
				System.out.println("#######" + sendMsg);

				pr.println(sendMsg);
				pr.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stdIn != null)
					stdIn.close();
				if (pr != null)
					pr.close();
				if (br != null)
					br.close();
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
