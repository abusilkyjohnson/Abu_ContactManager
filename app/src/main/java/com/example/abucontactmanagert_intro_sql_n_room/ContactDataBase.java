package com.example.abucontactmanagert_intro_sql_n_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//D: Database
@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDataBase extends RoomDatabase {

    //linking Data with DAO
    public abstract ContactsAbuDoa GetContactDAO();

    //Singleton Pattern
    private static ContactDataBase dbInstance;

    public static synchronized ContactDataBase GetInstance(Context context)
    {
        if (dbInstance == null)
        {

            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                                                ContactDataBase.class,"contact_db").fallbackToDestructiveMigration().build();

        }
        return dbInstance;
    }
}
