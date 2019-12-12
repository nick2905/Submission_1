package com.dicoding.filmku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //variabel data
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataDirector;
    private String[] dataDate;
    private String[] dataRate;
    private TypedArray dataPhoto;
    //variabel adapter
    private MovieAdapter adapter;
    //Variabel array
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call adapter
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        //__jalankan prepare untuk inisialisasi array yg di dalam string mengambil idnya
        prepare();
        //__Memasukkan datanya ke dalam ArrayList
        addItem();

        //Fungsi yang akan dilakukan terhadap respon atraksi user ke item listview tadi
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Set Data satu per satu dan memasukkannya kedalam array masing"
                Movie movie = new Movie();
                movie.setPhoto(dataPhoto.getResourceId(i,1));
                movie.setName(dataName[i]);
                movie.setDescription(dataDescription[i]);
                movie.setDirector(dataDirector[i]);
                movie.setDate(dataDate[i]);
                movie.setRate(dataRate[i]);
                //Melakukan Intent
                Intent moveIntent = new Intent(MainActivity.this, MovieDetail.class);
                moveIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
                startActivity(moveIntent);
            }
        });
    }

    //method memasukkan isi data
    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setDirector(dataDirector[i]);
            movie.setDate(dataDate[i]);
            movie.setRate(dataRate[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    //method inisialisasi array
    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataDirector = getResources().getStringArray(R.array.data_director);
        dataDate = getResources().getStringArray(R.array.data_tanggal);
        dataRate = getResources().getStringArray(R.array.data_rate);
    }
}
