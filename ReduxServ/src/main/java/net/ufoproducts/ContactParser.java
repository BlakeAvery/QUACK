package net.ufoproducts;

import java.util.ArrayList;
import java.io.*;
import com.twilio.type.PhoneNumber;
public class ContactParser {
    public ArrayList<Contact> parseList() throws Exception {
        BufferedReader read = new BufferedReader(new FileReader(new File("contacts.txt")));
        ArrayList<String> yeet = new ArrayList<>();
        for(int x = 0; x < 3; x++) {
            yeet.add(read.readLine());
        }
        ArrayList<Contact> ret = new ArrayList<>();
        for(int x = 0; x < yeet.size(); x++) {
            String[] onJah = yeet.get(x).split(";");
            ret.add(new Contact(onJah[0], new PhoneNumber(onJah[1]), enumParser(onJah[2])));
        }
        return ret;
    }
    private Relationship enumParser(String s) {
        switch(s) {
            case "GRANDCHILD":
                return Relationship.GRANDCHILD;
            case "CHILD":
                return Relationship.CHILD;
            case "RELATIVE":
                return Relationship.RELATIVE;
            case "CARETAKER":
                return Relationship.CARETAKER;
            default:
                return Relationship.RELATIVE;
        }
    }
}
