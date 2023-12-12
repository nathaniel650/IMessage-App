# iMessageChatApplication
## Introduction
iMessageChatApplication is a desktop-based chat application developed using Java Swing and socket programming.

This application makes use of using java.io and java.net packages to create a chat application.

## Components
### Server
The server module waits for clients to connect. Upon a successful connection, it allows clients to exchange messages. It is the backbone of the application, facilitating the communication between different clients.

### Client
The client module is used by the end-user to send requests to the server. Utilizing this module, the user can connect to and communicate with the server.

## Operational Concepts and Scenarios
The operation of the application is based on user inputs:

- **Initialization**: When the "Run" button is clicked, the chat form initializes a connection between the host (server) and the client machine.
- **Note**: The server must be started first before a client can connect.
- **Messaging Interface**:
- Contains a rich textbox to display messages from one user to another.
- Features a textbox for writing messages to be sent across the network.
- Includes a "Send" button for transmitting messages.
- **Message** Transmission: When the "Send" button is clicked, the text in the textbox is encoded and sent as a packet over the network to the client machine, where it is decoded and displayed in the rich textbox.

## Getting Started
To get started with the iMessageChatApplication:

1. **Start the Server: Launch the server application first.
2. **Launch the Client: Open the client application and connect to the server.
3. **Begin Chatting: Once connected, start sending and receiving messages


## Server Test

![Image of Server Application](https://i.imgur.com/eA4S03t.png)


## Client Test

![Image of Client Application](https://i.imgur.com/Eztws1U.png)


## Server and Client Test

![Image of the Server and Client Communicating with Each Other](https://i.imgur.com/qtZtZkG.png)