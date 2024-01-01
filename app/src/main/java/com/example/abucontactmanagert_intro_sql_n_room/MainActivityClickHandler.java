package com.example.abucontactmanagert_intro_sql_n_room;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.room.Insert;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context)
    {
        this.context = context;
    }

    public void onFABClicked(View view){
        Intent i = new Intent(view.getContext(),AddNewContactActivity.class);
        context.startActivity(i);
    }
}
