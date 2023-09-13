package com.pfa.service;

import com.pfa.event.PublicEvent;
import com.pfa.model.Model_File_Sender;
import com.pfa.model.Model_Receive_Message;
import com.pfa.model.Model_Send_Message;
import com.pfa.model.Model_User_Account;
import io.socket.client.Socket;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataFormat;

/**
 *
 * @author safae
 */
public class Service {
    
    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;
    private List<Model_File_Sender> fileSender ;
    
    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
            
        }
        return instance;
    }
    
    private Service() {
        fileSender = new ArrayList<>();
    }
    
    public void statServer() {
        
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
                
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer)os[0];
                    boolean status = (Boolean) os[1];
                    if(status){
                        //connect
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    }else{
                        //disconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Receive_Message message = new Model_Receive_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            client.open();
        } catch (URISyntaxException ex) {
            error(ex);
        }
        
    }
    
    public Model_File_Sender addFile(File file, Model_Send_Message message) throws IOException{
        Model_File_Sender data = new Model_File_Sender(file, client, message);
        message.setFile(data);
        fileSender.add(data);
        // send  file one by one
        if (fileSender.size() == 1) {
            data.initSend();
        }
        return data;
    }
  
    public void fileSendFinish(Model_File_Sender data) throws IOException{
    fileSender.remove(data);
    if(!fileSender.isEmpty()){
        //start sending file after the old one finished
        fileSender.get(0).initSend();
    }
}
    
    public Socket getClient() {
        return client;
    }
    
    private void error(Exception e) {
        System.err.println(e);
    }
    
    public Model_User_Account getUser() {
        return user;
    }
    
    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
}
