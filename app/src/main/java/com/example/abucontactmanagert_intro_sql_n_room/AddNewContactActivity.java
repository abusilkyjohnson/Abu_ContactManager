package com.example.abucontactmanagert_intro_sql_n_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.abucontactmanagert_intro_sql_n_room.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNew_Activity_ClickHandler handler;
    private Contacts contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contacts = new Contacts();

        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);

        handler = new AddNew_Activity_ClickHandler(contacts,this);

        binding.setContact(contacts);
        binding.setAbuClickHandler(handler);
    }
}