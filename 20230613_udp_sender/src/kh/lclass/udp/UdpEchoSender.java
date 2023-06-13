package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender {
	public static void main(String[] args) {
		new UdpEchoSender().senderUdp();
	}
	public void senderUdp() {
		//포트번호 정함
		int myport = 5001;
		int desport = 6001;
		String destName = "localhost";
		
		DatagramSocket dSock = null;
		BufferedReader br = null;
		try {
			//DatagramSocket 객체 생성		
			dSock = new DatagramSocket(myport);//매가인자 없으면 자동 port번호 할당. 지정하면 해당 포트 번호로 소켓 생성
			
			//전달할 메시지
			String sendMsg ="안녕";
			
			//메시지 전달
			InetAddress destIp= null;
			try {
//				3. 연결한 클라이언트 IP주소를 가진 InetAddress 객체 생성
				destIp = InetAddress.getByName(destName);
//				4. 전송할 메시지를 byte[]로 바꿈
				byte[]byteMsg = sendMsg.getBytes();
//				5. 전송할 메시지를 DatagramPacket 객체에 담음
				DatagramPacket sendData
				=new DatagramPacket(byteMsg,byteMsg.length, destIp, desport);
//				6. 소켓 레퍼런스를 사용하여 메시지를 전송
				dSock.send(sendData);
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//메시지 수신
			byte[]byteMsg = new byte[1000];
			//수신받을 메시지를 DatagramPacket 객체에 담음
			DatagramPacket receiveData
			=new DatagramPacket
			(byteMsg, byteMsg.length);
			dSock.receive(receiveData);
			//전달받은 메시지 정보들
			System.out.println("=====전달받은 정보들=====");
			System.out.println(byteMsg.length);
			System.out.println(receiveData.getData().length);
			System.out.println(receiveData.getLength());
			System.out.println(receiveData.getAddress());
			System.out.println(receiveData.getPort());
			String receivedStr= new String(receiveData.getData());
			System.out.println("Echo메시지"+ receivedStr);
		} catch (SocketException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			try {
				if(br != null)br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(dSock != null) dSock.close();
		}
		
	}

}
