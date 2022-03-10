# Lightweight_multithreaded_server
I developed this Lightweight multithreaded server using Java.

This project comprises of different parts, like:-

 1- Constructing the interactive GUIs
 
 2- Using the java.net package for Socket Programming.
 
 3- Allowing Multi-threading, so two or more users can interact among themselves with server as the medium of there interaction

This project is made using JAVA. javax.swing pacakage is used for developing GUI, java.net for creating Sockets
In this source code, you'll find a file named  Server.java in which there will be code for Server Side Socket Programming. Similarly three more files named Client1.java, Client2.java and Client3.java in which there will be code for three different Clients. The source code of all three clients will be completely identical, and one more file named LoginFrame.java. It is a small piece of code in which a GUI is created for the login form, from where all three clients will login to server. 

The username of each Client is there respective client name, i.e., Client1 for first client , Client2 for second client and so on. The password for each client is "123"(password is kept simple and similar for the sake of simplicity, but you can change it, as per your wish). 


1- Start the Server.java first, then login form will open.

2- Enter the username and password of each client and click on login

3- Start typing and sending message in group chat.


Note:- Don't close the login form while chatting, because the login form is directly connected to the Server-side socket, and thus closing Login form result in closing the Server and destroy all the connections established betweeen the clients and server.
