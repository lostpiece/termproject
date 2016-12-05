package com.example.ensu4.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static com.example.ensu4.termproject.R.layout.activity_modify;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder  {


        public TextView nameTextView;
        public Button editButton;
        public Button delectButton;
        public ContactsAdapter mContacts;



        public ViewHolder(Context context, View itemView, ContactsAdapter contacts) {

            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.txview);
            editButton = (Button) itemView.findViewById(R.id.button1);
            delectButton = (Button) itemView.findViewById(R.id.button2);
            mContacts = contacts;
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(getApplicationContext(), schedule.class);
                    //startActivity(intent,activity_modify);
                }
            });
            delectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    mContacts.removeItem(position);
                }
            });
        }





    }


    private List<Contact> mContacts;
    private Context mContext;

    public ContactsAdapter(Context context, List<Contact> contacts) {
        mContacts = contacts;
        mContext = context;
    }



    private Context getContext() {
        return mContext;
    }


    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, contactView,this);
        return viewHolder;
    }
    public void removeItem(int p) {
        mContacts.remove(p);
        notifyItemRemoved(p);

    }

    @Override
    public void onBindViewHolder(final ContactsAdapter.ViewHolder viewHolder, int position) {

        Contact contact = mContacts.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());
        final Button button1 = viewHolder.editButton;
        button1.setText("Edit");
        final Button button2 = viewHolder.delectButton;
        button2.setText("Delect");

    }


    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}

