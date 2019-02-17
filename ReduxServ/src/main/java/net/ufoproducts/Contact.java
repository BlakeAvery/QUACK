package net.ufoproducts;

import com.twilio.type.PhoneNumber;

public class Contact {
    public String name;
    public PhoneNumber number;
    public Relationship relationship;
    public Contact(String na, PhoneNumber num, Relationship rel) {
        name = na;
        number = num;
        relationship = rel;
    }
}
