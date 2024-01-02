package com.example.abucontactmanagert_intro_sql_n_room;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNew_Activity_ClickHandler {

    Contacts contacts;
    Context context;
    ContactAppViewModel contactAppViewModel;

    public AddNew_Activity_ClickHandler(Contacts contacts, Context context,ContactAppViewModel contactAppViewModel)
    {
        this.contacts = contacts;
        this.context = context;
        this.contactAppViewModel = contactAppViewModel;
    }

    public void onAddContactSubmitButt(View view)
    {
        if(contacts.get_name() == null || contacts.get_email() == null)
        {
            Toast.makeText(context,"CANNOT BE EMPTY",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(context,MainActivity.class);
           // i.putExtra("Name", contacts.get_name());//key is case sensative
            //i.putExtra("Email",contacts.get_email());
            Contacts c = new Contacts(contacts.get_name(), contacts.get_email());

            contactAppViewModel.AddContact(c);//this put its in our instance of view mode

            context.startActivity(i);
        }
    }
}
