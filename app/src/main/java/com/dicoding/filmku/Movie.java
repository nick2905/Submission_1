package com.dicoding.filmku;

import android.os.Parcel;
import android.os.Parcelable;

//Syarat menggunakan Parcelable
public class Movie implements Parcelable {
    public int getPhoto() {


            return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //deklarasi variabel dengan private karna hanya di gunakan di child class daripada parent
    private int photo;
    private String name;
    private String Description;
    private String date;
    private String rate;
    private String director;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.Description);
        dest.writeString(this.date);
        dest.writeString(this.rate);
        dest.writeString(this.director);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.Description = in.readString();
        this.date = in.readString();
        this.rate = in.readString();
        this.director = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
