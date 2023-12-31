package com.example.abucontactmanagert_intro_sql_n_room;

import java.util.List;

public class AbuRepo {
//if a method is in the DOA it has has to be in the repository
    private final ContactsAbuDoa contactsAbuDoa;

    public AbuRepo(ContactsAbuDoa contactsAbuDoa) {
        this.contactsAbuDoa = contactsAbuDoa;
    }

    public void AddContact(Contacts contacts)
    {
        contactsAbuDoa.InsertAbu(contacts);
    }

    public void DeleteContact(Contacts contacts)
    {
        contactsAbuDoa.DeleteAbu(contacts);
    }

    public List<Contacts> GetAllContacts()
    {
        return  contactsAbuDoa.AbuGetAllContacts();
    }
}
