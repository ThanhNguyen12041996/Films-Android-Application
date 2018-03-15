package com.example.minhthanh.listview_lab3_androidth;

/**
 * Created by minh thanh on 3/14/2018.
 */

public class Profile {
    private String vote_count;
    private String id,video,vote_average,title,popularity,poster_path,original_language,original_title;
    private String backdrop_path,adult,overview,release_date;

    public Profile() {
    }

    public String getvote_count() {
        return vote_count;
    }

    public String getvideo() {
        return video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getPopularity()
    {
        return popularity;
    }

    public String getid() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }


    public String getBackdrop_path() {
        return backdrop_path;
    }
    public String getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setvote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public void setid(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "vote_count='" + vote_count + '\'' +
           //     ", id='" + id + '\'' +
                '}';
    }
}
