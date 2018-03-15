package com.example.minhthanh.listview_lab3_androidth;

import java.util.ArrayList;

/**
 * Created by minh thanh on 3/11/2018.
 */

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name) {
        mName = name;
     //   mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId));//i <= numContacts / 2));
        }

        return contacts;
    }
}
