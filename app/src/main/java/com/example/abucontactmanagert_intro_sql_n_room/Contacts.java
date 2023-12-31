package com.example.abucontactmanagert_intro_sql_n_room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


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
    //column in the database table.This annotation provides control over column specific properties and behaviors.
    @ColumnInfo(name = "contact_id")//this is optional if i dont do this the name of column will variable name like the 2 string s below
    @PrimaryKey(autoGenerate = true)//we always need a primary key
    private int _id;

    private String _name;
    private String _email;

    public Contacts(int _id, String _name, String _email) {
        this._id = _id;
        this._name = _name;
        this._email = _email;
    }

    public Contacts() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}
