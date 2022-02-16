package br.com.letscode.contacts.beans;

import br.com.letscode.contacts.model.Contact;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import java.util.Collections;
import java.util.List;

public class ListContact {

    private final List<Contact> contacts = Collections.singletonList(new Contact("Lucio", "lucio@lets"));


    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts(){
        return contacts;
    }
}
