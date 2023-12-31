package com.example.abucontactmanagert_intro_sql_n_room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


//This @ means EntityAn entity is a fundamental component that represents a table in the SQLite database.
//Each entity class corresponds to one table and the fields properties or the variables within the entity
//class represent INT columns in that table.
//Entities define the structure and the schema of your database tables.
@Entity(tableName = "contactsAbu_Table")
public class Contacts{

    // I have only one entity class called contacts, and I have inside this table three
    //columns, contact ID, contact name and contact email one of type int and two of type strings.
//////////////////////////////////////////////////////////////////////////////////

    //@ColumnInfo: used To specify additional details about how a field, property or variable in an entity class maps to a
    //column in the database table.
    //This annotation provides control over column specific properties and behaviors.
    @ColumnInfo
    private int _id;

    private String _name;
    private String _email;

}
