package net.ufoproducts;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;

public class Messenger {
    public static boolean send(Alert alert) {
        //ContactParser parser = new ContactParser();
        ArrayList<Contact> contacts = new ArrayList<>();
        /*try {
            contacts = parser.parseList();
        } catch(Exception e) {
            contacts = null;
            System.err.println("F: " + e);
        }*/
        contacts.add(new Contact("Alice Prince", new PhoneNumber("+13473892365"), Relationship.RELATIVE));
        contacts.add(new Contact("Alfred Gupta", new PhoneNumber("+13473561439"), Relationship.CARETAKER));
        contacts.add(new Contact("William Olson", new PhoneNumber("+19086279115"), Relationship.CHILD));
        String messageTemplate = "This is an automated alert from QUACK. Your $relationship has pressed the alert button on their QUACK bracelet and needs help. " +
                "They are currently located at these GPS coordinates: $lat, $lon and initiated this alert at $timedate. Please proceed to this location as soon as possible.";
        //System.out.println(contacts.get(0).name + contacts.get(0).number + contacts.get(0).relationship);
        sans(contacts, alert);
        return true;
    }
    private static void sans(ArrayList<Contact> c, Alert a) {
        Twilio.init("AC95def388b9144bc2a0b83a3d9055b780", "4d9482b08136af9b26c2e21116b1244f");//TODO: Abstract these away from this file!
        for(int x = 0; x < c.size(); x++) {
            String messageMeme = "This is an urgent alert from QUACK. Your " + relationParser(c.get(x).relationship) + " has pressed the alert button on their QUACK bracelet and needs help. " +
                    "They are currently located at these GPS coordinates: " + a.lat + ", " + a.lon + ". This alert was initiated at " + a.time + ". Please proceed to this locaton as soon as possible.";
            Message.creator(c.get(x).number, new PhoneNumber("+16464614982"), messageMeme).create();
        }
    }
    private static String relationParser(Relationship r) {
        switch(r) {
            case RELATIVE:
                return "relative";
            case CHILD:
                return "parent";
            case GRANDCHILD:
                return "grand-parent";
            case CARETAKER:
                return "dependent";
            default:
                return "sans";
        }
    }
}
