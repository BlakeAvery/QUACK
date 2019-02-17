import java.net.*; import java.io.*;
import net.ufoproducts.*;
public class Main {
    public static void main(String[] args) {
        ServerSocket succ;
        //I wanna die
        try {
            succ = new ServerSocket(8051);
        } catch(Exception e) {
            succ = null;
        }
        while(true) {
            //Main serv code
            try {
                Socket system = succ.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(system.getInputStream()));
                String request = input.readLine();
                System.out.println(request);
                if(request != null) {
                    Alert a = Alert.getAlert(request);
                    Messenger.send(a);
                }
            } catch(Exception e) {
                System.err.println("F: " + e);
            }
        }
    }
}
