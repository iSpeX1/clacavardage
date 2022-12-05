import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import database.DatabaseManager;
import model.Message;
import model.User;

/**
 * This class is the main class of the project.
 * 
 */
public class Main{

    // ip 12:48:42 -> 192.168.56.1
    public static void main (String[] args){
        Message msg = new Message("petit caca");
        Message msg2 = new Message();
        User este = new User("este");
        User gaboche = new User("gaboche");
        msg.setSender(este);
        msg.setReceiver(gaboche);
        System.out.println(msg.toString());

        DatabaseManager db = new DatabaseManager();   
        db.insertMessage(gaboche.getIP(), msg);
        ArrayList<Integer> list = db.findListOfIndex(gaboche.getIP(), "caca");
        //printList(list);
        for (int i = 0; i < list.size(); i++){
            msg2 = db.getMsgFromIndex("gaboche", list.get(i));
            System.out.println(msg2.toString());
            //db.deleteMessage(gaboche.getIP(), list.get(i));
        }

    }

    //print every element of the arrayList
    public static void printList(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
