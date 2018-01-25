package com.example.android.randomuserapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.randomuserapp.R;
import com.example.android.randomuserapp.model.User;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment {
    View rootView;
    User detailUser;
    ImageView userPic;
    TextView name, location,email,dob,cell;
    Context context;


    public UserDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);
        context = getActivity();
        name = (TextView) rootView.findViewById(R.id.user_detail_name_textview);
        location = (TextView) rootView.findViewById(R.id.user_detail_location_textview);
        email = (TextView) rootView.findViewById(R.id.user_detail_email_textview);
        dob = (TextView) rootView.findViewById(R.id.user_detail_dob_textview);
        cell = (TextView) rootView.findViewById(R.id.user_detail_cell_textview);
        userPic = (ImageView) rootView.findViewById(R.id.user_detail_image_view);

        Picasso.with(context)
                .load(detailUser.getPicture().getLarge())
                .resize(500, 500)
                .centerInside()
                .into(userPic);
        String fullName = detailUser.getName().getTitle();
        StringBuilder sbName = new StringBuilder(fullName);
        sbName.append(" ").append(detailUser.getName().getFirst());
        sbName.append(" ").append(detailUser.getName().getLast());

        name.setText(sbName.toString());

        String fullLocation = detailUser.getLocation().getStreet();
        StringBuilder sbLocation = new StringBuilder(fullLocation);
        sbName.append(" ").append(detailUser.getLocation().getCity());
        sbName.append(" ").append(detailUser.getLocation().getState());
        sbName.append(" ").append(detailUser.getLocation().getPostcode());

        location.setText(sbLocation.toString());
        email.setText(detailUser.getEmail());
        dob.setText(detailUser.getDob());
        cell.setText(detailUser.getCell());

        return rootView;
    }

    public void updateUser(User user){
        detailUser = user;
    }

}
