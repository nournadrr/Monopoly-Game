/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class chatServer extends Thread{
    int port;
    ServerSocket serverSocket;
    
    public chatServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                Socket socket1 = serverSocket.accept();
                PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
                BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                System.out.println("connected");
                
                Socket socket2 = serverSocket.accept();
                PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);
                BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                System.out.println("connected");
                
                String msg1, msg2;
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String msg1 = "-tech- ";
                            try {
                                
                                msg1 += in1.readLine();
                            } catch (IOException ex) {
                                Logger.getLogger(chatServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out2.println(msg1);
                            out2.flush();
                        }
                    }
                    
                }).start();
                
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String msg2 = "player";
                            try {
                                
                                msg2 = in2.readLine();
                            } catch (IOException ex) {
                                Logger.getLogger(chatServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out1.println(msg2);
                            out1.flush();
                        }
                    }
                    
                }).start();
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(chatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
