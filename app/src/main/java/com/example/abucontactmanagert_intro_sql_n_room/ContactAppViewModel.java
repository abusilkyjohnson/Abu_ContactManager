package com.example.abucontactmanagert_intro_sql_n_room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.net.PortUnreachableException;
import java.util.List;

public class ContactAppViewModel extends AndroidViewModel {
    //If you need to use the context inside your view model, you should use Android View model AVM instead
    //of a view model because it contains the application context.

    private AbuRepo myRepo;

    private LiveData<List<Contacts>> allContact;

    public ContactAppViewModel(@NonNull Application application) {
        super(application);
        this.myRepo = new AbuRepo(application);
    }

    public LiveData<List<Contacts>> GetAllContact()
    {
        allContact = myRepo.GetAllContacts();

        return allContact;
    }

    public void AddContact(Contacts contacts)
    {
      myRepo.AddContact(contacts);
    }


    public void DeleteContact(Contacts contacts)
    {
        myRepo.DeleteContact(contacts);
    }
}
