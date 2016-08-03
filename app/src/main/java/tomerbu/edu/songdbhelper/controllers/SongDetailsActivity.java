package tomerbu.edu.songdbhelper.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tomerbu.edu.songdbhelper.R;
import tomerbu.edu.songdbhelper.db.SongDAO;
import tomerbu.edu.songdbhelper.models.Song;

public class SongDetailsActivity extends AppCompatActivity {

    EditText etSongTitle, etArtist, etDuration, etImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        etArtist = (EditText) findViewById(R.id.etArtist);
        etSongTitle = (EditText) findViewById(R.id.etTitle);
        etDuration = (EditText) findViewById(R.id.etDuration);
        etImageUri = (EditText) findViewById(R.id.etImage);

        Intent intent = getIntent();


       // String id = intent.getStringExtra("_ID");

        //if id is not null:
        //Take the song by id from the database:
        //AND Put the song detials in the editexts
        //finally:
        //The save method should call update instead of insert
    }

    public void save(View view) {
        SongDAO dao = new SongDAO(this);

        Song s = new Song(
                etSongTitle.getText().toString(),
                etArtist.getText().toString(),
                etDuration.getText().toString(),
                etImageUri.getText().toString()
        );


        //if (_id!=null) call update instead.
        dao.insert(s);

        Intent mainIntent = new Intent(this, SongDBActivity.class);
        startActivity(mainIntent);

        //finish();
    }
}
