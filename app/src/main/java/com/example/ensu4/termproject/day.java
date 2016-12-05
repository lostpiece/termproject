package com.example.ensu4.termproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class day extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.dayContacts);

        contacts = Contact.createContactsList(20);
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        rvContacts.setAdapter(adapter);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        rvContacts.setLayoutManager(gridLayoutManager);


        RecyclerView.ItemDecoration itemDecoration = new
                MarginItemDecoration(20);
        rvContacts.addItemDecoration(itemDecoration);

        rvContacts.setHasFixedSize(true);
        contacts.add(0, new Contact("Barney", true));
        adapter.notifyItemInserted(0);
    }
    ArrayList<Contact> contacts;
}
