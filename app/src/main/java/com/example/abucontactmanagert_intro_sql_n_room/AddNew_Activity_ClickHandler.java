package com.example.abucontactmanagert_intro_sql_n_room;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNew_Activity_ClickHandler {

    Contacts contacts;
    Context context;

    public AddNew_Activity_ClickHandler(Contacts contacts, Context context)
    {
        this.contacts = contacts;
        this.context = context;
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
            i.putExtra("Name", contacts.get_name());//key is case sensative
            i.putExtra("Email",contacts.get_email());
            context.startActivity(i);
        }
    }
}
