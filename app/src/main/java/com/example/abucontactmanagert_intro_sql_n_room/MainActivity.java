package com.example.abucontactmanagert_intro_sql_n_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.abucontactmanagert_intro_sql_n_room.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private ContactDataBase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //Adapter
    private AbuAdapter abuAdapter;

    //binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handlers = new MainActivityClickHandler(this);

        mainBinding.setAbuClickHandler(handlers);

        //RecyclerView
        RecyclerView recyclerView = mainBinding.recyclerView;//this line obatains a reference that we can interact with
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //Database
        contactDatabase = ContactDataBase.GetInstance(this);

        //ViewModel
        ContactAppViewModel viewModel = new ViewModelProvider(this).get(ContactAppViewModel.class);

        //Inserting a new contact for example reason
        Contacts c1 = new Contacts("Abu","Siklyjohnson@gmail.com");
        viewModel.AddContact(c1);//we work directly with the viewmodel/

        //Loading the Data from ROOM db
        viewModel.GetAllContact().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                for (Contacts c: contacts)//for each loop
                {
                    //we had to change the list up top to specifcy arraylist because of the conflict variable
                    //name in this parameter
                    Log.v("Tagy",c.get_name());
                    contactsArrayList.add(c);

                }
                abuAdapter.notifyDataSetChanged();
            }
        });

        //Adapter
        abuAdapter = new AbuAdapter(contactsArrayList);


        //Linking the RecyclerView with the Adapter
        recyclerView.setAdapter(abuAdapter);
    }
}