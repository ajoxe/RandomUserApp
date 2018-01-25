package com.example.android.randomuserapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.randomuserapp.R;
import com.example.android.randomuserapp.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by amirahoxendine on 1/24/18.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView userName;
    public ImageView userThumb;
    public UserViewHolder(View itemView) {
        super(itemView);
        userName = (TextView) itemView.findViewById(R.id.user_item_name_textview);
        userThumb = (ImageView) itemView.findViewById(R.id.user_item_thumb_image_view);
    }
    public void onBind(User user, Context context){
        String fullName = user.getName().getTitle();
        StringBuilder sb = new StringBuilder(fullName);
        sb.append(" ").append(user.getName().getFirst());
        sb.append(" ").append(user.getName().getLast());
        userName.setText(sb.toString());
        Picasso.with(context)
                .load(user.getPicture().getLarge())
                .resize(500, 500)
                .centerInside()
                .into(userThumb);
        Log.d("thumbnail", "userthumb" + user.getPicture().getMedium());
    }

}
