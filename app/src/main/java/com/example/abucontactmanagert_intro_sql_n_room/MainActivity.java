package com.example.abucontactmanagert_intro_sql_n_room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
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
        /////////////////////////////made this commented to stop recreation of abu///////////////////Contacts c1 = new Contacts("Abu","Siklyjohnson@gmail.com");
        ////////////////////////////////////////////////viewModel.AddContact(c1);//we work directly with the viewmodel/

        //Loading the Data from ROOM db
        viewModel.GetAllContact().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {

                contactsArrayList.clear();//we need this so we clear the array list
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

        ///swip to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            //this method creates an instance of itemtouchhelper that provide support
            //for handling touch gestures especially for swipe and drag drop actions
            // 1st parameter refer to In this case specifies the drag and drop directions.
            //Zero means no drag and drop is supported.
            //The second argument is Itemtouchhelper dot left specifies the swipe directions.
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                //refers to when item is moved
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                //Viewholder and direction Viewholder the viewholder of the item that was swiped and direction and integer
                //indicating the swipe direction left or right and inside the method you define the action to be taken
                //when an item is swiped1
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());
                viewModel.DeleteContact(c);

            }
        }).attachToRecyclerView(recyclerView);
        //This method attached to recycler view is used with Android's Itemtouchhelper class to attach it to a
        //recycler view.
        //drop gestures for the items within the recycler view.
    }
}