/*
 * Decompiled with CFR 0.152.
 */
package me.qlutch.sucks.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class ClientThread extends Thread {
    private Socket connection;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Consumer<String> stringConsumer;
    private Consumer<ClientThread> connectionHandlerConsumer;
    private boolean bJ;

    public ClientThread(Socket inSocket, Consumer<String> messageReceive, Consumer<ClientThread> disconnected) {
        this.connection = inSocket;
        this.stringConsumer = messageReceive;
        this.bJ = true;
        this.connectionHandlerConsumer = disconnected;
    }

    @Override
    public void run() {
        try {
            byte[] bytes;
            int bytesToRead;
            this.inputStream = new DataInputStream(this.connection.getInputStream());
            this.outputStream = new DataOutputStream(this.connection.getOutputStream());
            while (this.bJ && (bytesToRead = this.inputStream.read(bytes = new byte[2048])) >= 0) {
                String msgReceived = new String(bytes);
                if (this.stringConsumer == null) continue;
                this.stringConsumer.accept(msgReceived);
            }
            this.inputStream.close();
            this.outputStream.close();
            this.connection.close();
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        this.disconnect();
    }

    public void broadcastMessage(String msg) {
        try {
            this.outputStream.write(msg.getBytes());
        }
        catch (IOException e2) {
            e2.printStackTrace();
            this.disconnect();
        }
    }

    public void disconnect() {
        try {
            if (!this.connection.isClosed()) {
                this.connection.shutdownInput();
                this.connection.shutdownOutput();
                this.connection.close();
            }
            this.bJ = false;
            this.connectionHandlerConsumer.accept(this);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}

