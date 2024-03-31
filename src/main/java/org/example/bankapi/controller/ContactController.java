package org.example.bankapi.controller;

import org.example.bankapi.entity.Contact;
import org.example.bankapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/myContact")
    public ResponseEntity<Contact> getMyContact(@RequestBody Contact contact) {
        contact.setContactId(0);
        contactService.createContact(contact);
        return ResponseEntity.ok().body(contact);
    }

    @GetMapping("/allContacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok().body(contactService.getAllContacts());
    }


}
