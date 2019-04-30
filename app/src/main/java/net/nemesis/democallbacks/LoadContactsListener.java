package net.nemesis.democallbacks;

import java.util.ArrayList;

public interface LoadContactsListener {
    void onLoadContacts(ArrayList<Contact> contacts);
    void onFailLoadContacts(String error);
}
