import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * UDPClient which sends a message ('Hello') to the UDPServer on localhost
 * and then waits for response.
 * Once the sever responds, the UDPClient displays the sent and received messages.
 *
 */
public class UDPClient {

    // Defining port number (to connect to server)
    public static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create datagram socket for client
            DatagramSocket clientSocket = new DatagramSocket();
            // Get IP address of server (localhost)
            InetAddress serverIPAddress = InetAddress.getByName("localhost");

            // arrays to hold data being sent and received
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            // Message to be sent to the server
            String message = "Hello";
            sendData = message.getBytes(); // Converting string message to bytes

            // Datagram packet to receive servers response
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);
            clientSocket.send(sendPacket); // Send packet to server

            // Datagram packet to receive servers response
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // Wait and receive servers response
            clientSocket.receive(receivePacket);

            // Converting received byte data back to string
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Printing sent and received messages to console
            System.out.println("Client program sends the message: " + message);
            System.out.println("Client program receives the message: " + serverResponse);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
