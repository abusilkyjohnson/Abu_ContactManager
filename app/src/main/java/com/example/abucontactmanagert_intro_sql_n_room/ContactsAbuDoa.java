package com.example.abucontactmanagert_intro_sql_n_room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
// DAO: Database Access Object
//We made this an interface
@Dao
public interface ContactsAbuDoa {

    @Insert//annotation to let system know thats an insert method
    void InsertAbu(Contacts contacts);//this method is responsible for inserting data into a database table

    @Delete
    void DeleteAbu(Contacts contacts);

    //the query annotation allows you to define custom SQL queries and map the results to Java or Kotlin
    //objects.and the query annotation allows you to define custom SQL queries and map the results to Java or Kotlin
    @Query("SELECT * FROM contactsAbu_Table")
    LiveData<List<Contacts>> AbuGetAllContacts();
}
