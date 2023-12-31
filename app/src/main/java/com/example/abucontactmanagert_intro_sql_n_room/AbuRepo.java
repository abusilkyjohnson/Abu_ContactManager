package com.example.abucontactmanagert_intro_sql_n_room;

import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbuRepo {
//if a method is in the DOA it has has to be in the repository
    private final ContactsAbuDoa contactsAbuDoa;
    ExecutorService executorService;
    Handler handler;
    public AbuRepo(ContactsAbuDoa contactsAbuDoa) {
        this.contactsAbuDoa = contactsAbuDoa;
        //Used backg database operation ensures order
        executorService= Executors.newSingleThreadExecutor();

        //Used for updating the UI
        handler = new Handler(Looper.getMainLooper()); // we used the os version of handler
    }

    public void AddContact(Contacts contacts)
    {



        //Runable: allows access to run method that allow the code to execute at the same time in the background
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsAbuDoa.InsertAbu(contacts);

            }
        });

        //contactsAbuDoa.InsertAbu(contacts);//we need to move the code above and add all those other codes to make sure this work properly
    }

    public void DeleteContact(Contacts contacts)
    {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsAbuDoa.DeleteAbu(contacts);

            }
        });
    }

    public List<Contacts> GetAllContacts()
    {
        return  contactsAbuDoa.AbuGetAllContacts();
    }
}
