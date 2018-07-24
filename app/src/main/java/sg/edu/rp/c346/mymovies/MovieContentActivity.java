package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieContentActivity extends AppCompatActivity {

    ImageView ivRate;
    TextView tvName;
    TextView tvYear;
    TextView tvCategory;
    TextView tvDescription;
    TextView tvWatchedOn;
    TextView tvTheatre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivRate = findViewById(R.id.imageViewPGs);
        tvName = findViewById(R.id.textViewName);
        tvYear = findViewById(R.id.textViewYear);
        tvCategory = findViewById(R.id.textViewCategory);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchedOn = findViewById(R.id.textViewWatchedOn);
        tvTheatre = findViewById(R.id.textViewTheatre);

        Intent intentReceived = getIntent();

        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("desc");
        String watchOn = intentReceived.getStringExtra("watchDate");
        String theatre = intentReceived.getStringExtra("theatre");
        String rating = intentReceived.getStringExtra("rated");

        tvName.setText(title);
        tvYear.setText(year+"-");
        tvCategory.setText(genre);
        tvDescription.setText("\n"+description+"\n");
        tvWatchedOn.setText("Watch on: "+watchOn);
        tvTheatre.setText("In Theatre: "+theatre+"\n");

        if(rating.equalsIgnoreCase("g")){
            ivRate.setImageResource(R.drawable.rating_g);
        }
        else if(rating.equalsIgnoreCase("pg")){
            ivRate.setImageResource(R.drawable.rating_pg13);
        }
        else if(rating.equalsIgnoreCase("pg13")){
            ivRate.setImageResource(R.drawable.rating_pg13);
        }
        else if(rating.equalsIgnoreCase("nc16")){
            ivRate.setImageResource(R.drawable.rating_nc16);
        }
        else if(rating.equalsIgnoreCase("m18")){
            ivRate.setImageResource(R.drawable.rating_m18);
        }
        else{
            ivRate.setImageResource(R.drawable.rating_r21);
        }
    }
}
