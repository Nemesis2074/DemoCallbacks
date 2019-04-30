package net.nemesis.democallbacks;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Contact implements Serializable {

    private String idContact;
    private String name;
    private String email;

    public Contact(){

    }

    public String getIdContact() {
        return idContact;
    }

    public void setIdContact(String idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void loadContacts(LoadContactsListener listener){

        try {
            ArrayList<Contact> contacts = new ArrayList<>();

            Contact contact = new Contact();
            contact.setIdContact("A");
            contact.setName("Adair Castillo");
            contact.setEmail("correo@demo.mx");
            contacts.add(contact);

            Contact contact1 = new Contact();
            contact1.setIdContact("B");
            contact1.setName("Juan Perez");
            contact1.setEmail("juan@demo.mx");
            contacts.add(contact1);

            Contact contact2 = new Contact();
            contact2.setIdContact("C");
            contact2.setName("Jose Arreola");
            contact2.setEmail("jose@demo.mx");
            contacts.add(contact2);

            listener.onLoadContacts(contacts);

        }catch(Exception e){
            listener.onFailLoadContacts(e.getMessage());
        }
    }

}
