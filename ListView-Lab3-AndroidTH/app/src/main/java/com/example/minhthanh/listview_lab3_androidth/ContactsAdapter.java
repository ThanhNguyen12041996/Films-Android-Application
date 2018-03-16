package com.example.minhthanh.listview_lab3_androidth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by nampham on 3/10/18.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>  {

    // Store a member variable for the contacts
    public List<Profile> mContacts;
    // Store the context for easy access
    private Context mContext;
    private String path = "https://image.tmdb.org/t/p/w500/";

    // Pass in the contact array into the constructor
    public ContactsAdapter(Context context, List<Profile> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView,mContext,mContacts);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Profile contact = mContacts.get(position);

        // Set item views based on your views and data model
        String textViewLength;
        String isVideo;
        TextView textView = viewHolder.nameTextView;
        TextView textViewTitle = viewHolder.titleTextView;
        ImageView PosterFilm = viewHolder.Poster;
        ImageView PlayButton = viewHolder.PlayButton;

        textViewTitle.setText(contact.getTitle());
        textViewLength = contact.getOverview();
        if(textViewLength.length() >= 150) {
            textView.setText(textViewLength.substring(0,150));
            textView.append("[...]");
        }
        else {
            textView.setText(textViewLength);
        }

        isVideo = contact.getvideo();
        if(isVideo.equalsIgnoreCase("true")) {
            PlayButton.setVisibility(View.VISIBLE);
        }
        if(isVideo.equalsIgnoreCase("false")) {
            PlayButton.setVisibility(View.INVISIBLE);
        }

        Picasso.with(getContext()).load(path+contact.getPoster_path()).into(PosterFilm);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView titleTextView;
        public ImageView Poster;
        public ImageView PlayButton;
        Context ctx;
        List<Profile> profileList ;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView, Context ctx, List<Profile> profileList) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnClickListener(this);
            this.ctx = ctx;
            this.profileList = profileList;

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            titleTextView = (TextView) itemView.findViewById(R.id.textView);
            Poster = (ImageView) itemView.findViewById(R.id.imageView);
            PlayButton = (ImageView) itemView.findViewById(R.id.imageView2);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Profile profile = this.profileList.get(position);
            Intent i = new Intent(ctx,FilmDetail.class);
            i.putExtra("Background",path+profile.getBackdrop_path());
            i.putExtra("OriginTitle",profile.getOriginal_title());
            i.putExtra("Date",profile.getRelease_date());
            i.putExtra("VideoDiscription",profile.getOverview());
            i.putExtra("VoteAverage",profile.getVote_average());
            i.putExtra("Video",profile.getvideo());
            this.ctx.startActivity(i);

        }
    }
}
