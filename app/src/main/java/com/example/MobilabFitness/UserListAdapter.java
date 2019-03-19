package com.example.MobilabFitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MobilabFitness.Database.User;

import java.util.Collections;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private static final String TAG = "UserListAdapter";



    class UserViewHolder extends RecyclerView.ViewHolder{
        private final TextView firstName;
        private final TextView lastName;
        private final TextView idNumber;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.textViewFirstName);
            lastName = itemView.findViewById(R.id.textViewLastName);
            idNumber = itemView.findViewById(R.id.textViewIdNumber);

        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUsers = Collections.emptyList(); // Cached copy of words

    UserListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = mInflater.inflate(R.layout.recyclerview_user_item,
                parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User current = mUsers.get(position);
        holder.firstName.setText(current.getFirstName());
        holder.lastName.setText(current.getLastName());
        holder.idNumber.setText(Integer.toString(current.getUid()));

        Log.i(TAG, "*** Current user at position " + position + ":  "+ current.toString());
    }

    void setUsers(List<User> users) {
        mUsers = users;
       // notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
