package org.example.bankapi.service;

import org.example.bankapi.entity.Contact;

import java.util.List;

public interface ContactService {

    void createContact(Contact contact);

    Contact getContactById(int contact);

    void deleteContact(int contactId);

    void updateContact(Contact contact);

    List<Contact> getAllContacts();
}
