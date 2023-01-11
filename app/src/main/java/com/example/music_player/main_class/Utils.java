package com.example.music_player.main_class;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.music_player.R;

public class Utils {
    public static void setImageToView (ImageView imageView, String url) {

             if (!url.equals("null")) {
                int margin = imageView.getContext().getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._5sdp);
                Glide.with(imageView.getContext())
                        .load(url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(margin)))
                        .into(imageView);
            }

    }

}
