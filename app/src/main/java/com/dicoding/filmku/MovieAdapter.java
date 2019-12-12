package com.dicoding.filmku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        //inisialisasi variaabel dengan private karna hanya digunakan untuk class itu sendiri
        private TextView txtName;
        private TextView txtDescription;
        private TextView txtDirector;
        private TextView txtDate;
        private TextView txtRate;
        private ImageView imgPhoto;


        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            txtDirector = view.findViewById(R.id.txt_director);
            txtDate = view.findViewById(R.id.txt_date);
            txtRate = view.findViewById(R.id.txt_rate);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie){
            txtName.setText(movie.getName());
            txtDescription.setText(movie.getDescription());
            txtDirector.setText(movie.getDirector());
            txtDate.setText(movie.getDate());
            txtRate.setText(movie.getRate());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }

}
