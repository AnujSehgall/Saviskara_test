package com.example.anuj.saviskara_test;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by anuj on 24/2/18.
 */

public class ContentAdapter  extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;


    ContentAdapter(Context con, String[] list) {

        this.context = con;
        DataModel.movies = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return DataModel.movies.length;
    }

    @Override
    public Object getItem(int i) {
        return DataModel.movies.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertview == null) {

            convertview =inflater.inflate(R.layout.card_item_template,null);
            holder = new ViewHolder();

            holder._cover = (ImageView) convertview.findViewById(R.id.img_cover_d);
            holder._background = (ImageView) convertview.findViewById(R.id.bckgrnd);
            holder._movies = (TextView) convertview.findViewById(R.id.txt_movie_details);
            holder._plot = (TextView) convertview.findViewById(R.id.txt_plot_d);
            holder._releaseDate = (TextView) convertview.findViewById(R.id.txt_release_d);
            holder._vw_blayer =  convertview.findViewById(R.id.vw_blacklayer);

            convertview.setTag(holder);

        } else {
            holder = (ViewHolder) convertview.getTag();
        }


        holder._movies.setText(DataModel.movies[i]);
        holder._plot.setText(DataModel.plot[i]);
        holder._releaseDate.setText("o "+DataModel.releaseDate[i]);
        //holder._cover.setImageResource(cover[i]);
        Picasso.with(context).load("http://i66.tinypic.com/351cz2h.png").into(holder._cover);
        // holder._background.setImageResource(background[i]);
        Picasso.with(context).load("http://i66.tinypic.com/351cz2h.png").into(holder._background);


        ObjectAnimator fade = ObjectAnimator.ofFloat(holder._vw_blayer, View.ALPHA, 1f,.3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();


        return convertview;
    }

    public class ViewHolder {

        ImageView _cover;
        ImageView _background;
        TextView _movies;
        TextView _plot;
        TextView _releaseDate;
        View _vw_blayer;


    }

}
