package sg.edu.rp.c346.mymovies;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> MovieList;
    CustomAdapter caMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.ListViewMovie);

        //Create data
        MovieList = new ArrayList<>();

        Calendar Moviedate1 = Calendar.getInstance();
        Moviedate1.set(2014,10,15);
        Calendar Moviedate2 = Calendar.getInstance();
        Moviedate2.set(2015,4,15);

        Movie Movie1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi",Moviedate1,"Golden Village-Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movie Movie2 = new Movie("Planes","2013","pg","Animation | Comedy",Moviedate2,"Cathay-AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");


        MovieList.add(Movie1);
        MovieList.add(Movie2);

        caMovieList = new CustomAdapter (this,R.layout.movie_content,MovieList);
        lvMovies.setAdapter(caMovieList);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(),MovieContentActivity.class);

                Movie theMovie = MovieList.get(i);

                intent.putExtra("title",theMovie.getTitle());
                intent.putExtra("year",theMovie.getYear());
                intent.putExtra("rated",theMovie.getRated());
                intent.putExtra("genre",theMovie.getGenre());
                intent.putExtra("date",theMovie.getWatched_on_String());
                intent.putExtra("theatre",theMovie.getIn_theatre());
                intent.putExtra("description",theMovie.getDescription());

                startActivity(intent);
            }
        });
    }



}
