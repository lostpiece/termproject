package com.example.ensu4.termproject;

import java.util.ArrayList;

public class Contact {
    private String mName;

    public Contact(String name, boolean online) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }


        return contacts;
    }
}
