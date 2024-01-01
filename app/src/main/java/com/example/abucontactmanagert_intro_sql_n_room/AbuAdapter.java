package com.example.abucontactmanagert_intro_sql_n_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abucontactmanagert_intro_sql_n_room.databinding.ContactListLayoutBinding;

import java.util.ArrayList;

public class AbuAdapter extends RecyclerView.Adapter<AbuAdapter.ContactViewHolder> {

    public AbuAdapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    private ArrayList<Contacts> contacts;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating new View items in recyclerView
        ContactListLayoutBinding contactListLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_layout,parent,false);
        return new ContactViewHolder(contactListLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        //called by recyclerview when ir needs to display or update an item
        //at a specific position in the list or grid

        Contacts currentContact = contacts.get(position);
        holder.contactListLayoutBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        if(contacts != null)
        {
            return contacts.size();
        }
        else {
            return 0;
        }
    }

    public void setContacts(ArrayList<Contacts> contacts)
    {
        this.contacts = contacts;
        //inform the recycler view that the underlying data set has changed and the recycler view should refresh its
        //views to reflect these changes. Tells it the data has changed
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        private ContactListLayoutBinding contactListLayoutBinding;
                                    //we removed the 1st parameter here
        public ContactViewHolder(@NonNull ContactListLayoutBinding contactListLayoutBinding) {
            super(contactListLayoutBinding.getRoot());//getroot provide access to the rootview allowing us to perform operation
            this.contactListLayoutBinding = contactListLayoutBinding;
        }
    }
}
