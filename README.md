# UDP-Socket-Client-Server
This project features the development of a UDP (User Datagram Protocol) based client-server system using Java. It emphasises a connectionless communication method, contrasting with the more common TCP-based systems. The core components of this project are two Java classes: UDPServer.java and UDPClient.java.

### UDPServer.java:
The server's role in this setup is to listen for incoming UDP packets and respond to them:
- **Port Listening:** The server listens on a specified port (12345) for incoming messages.
- **Receiving Messages:** When a message arrives, the server receives it as a UDP packet. The message is extracted from the packet and processed.
- **Processing and Response:** The server appends a humorous string to the received message, converting the concatenated message into a byte array.
- **Sending Back Data:** This new message is then sent back to the client's IP address and port number, demonstrating the server's capability to handle inbound and outbound data.

### UDPClient.java:
The client in this system is designed to initiate communication with the server:
- **Message Creation:** The client creates a simple "Hello" message.
- **Sending to Server:** This message is converted into bytes and sent to the server's IP address and port number in the form of a UDP packet.
- **Receiving Server Response:** The client waits and receives the server's response, which includes the original message appended with a humorous string.
- **Output Display:** The sent and received messages are displayed on the console, illustrating the full cycle of communication.

### Running the Programs:
- **Server Activation:** The UDPServer is run, and it starts listening for incoming messages on port 12345.
- **Client Interaction:** When the UDPClient is executed, it sends a "Hello" message to the server. The server responds with "Hello" followed by a humorous message. This exchange is displayed in the client's console.

This project demonstrates the fundamentals of UDP-based networking in Java. Unlike TCP, UDP is connectionless, meaning there is no need to establish a connection before data is sent. This makes UDP faster but less reliable than TCP. The project showcases how to handle UDP packets, extract data from them, and use this protocol for simple client-server communication. It's an excellent example of lightweight, non-connection-oriented communication between distributed systems.
