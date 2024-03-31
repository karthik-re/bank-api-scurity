package org.example.bankapi.service;

import org.example.bankapi.entity.Contact;
import org.example.bankapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public void createContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(int id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }

    @Override
    public void deleteContact(int contactId) {
        contactRepository.deleteById(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
