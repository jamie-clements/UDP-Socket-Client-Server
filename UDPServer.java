import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    // Defining port number (for server to listen for incoming messages)
    public static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {

            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            //
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running and waiting for client message...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                InetAddress clientIPAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String responseMessage = clientMessage + " I told my computer I needed a break... it gave me a byte!";
                sendData = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
