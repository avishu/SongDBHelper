package tomerbu.edu.songdbhelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import tomerbu.edu.songdbhelper.db.SongContract;
import tomerbu.edu.songdbhelper.db.SongDBHelper;

public class SongDBActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private EditText etTitle;
    private EditText etArtist;
    private EditText etDuration;
    private EditText etImageURI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViews();

    }

    private void findViews() {
        etTitle = (EditText) findViewById(R.id.etSongName);
        etArtist = (EditText) findViewById(R.id.etArtist);
        etDuration = (EditText) findViewById(R.id.etDuration);
        etImageURI = (EditText) findViewById(R.id.etImageURI);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_db, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void insert(View view) {
        SongDBHelper helper = new SongDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SongContract.Song.COL_TITLE, getSongTitle());
        values.put(SongContract.Song.COL_ARTIST, getArtist());
        values.put(SongContract.Song.COL_DURATION, getDuration());
        values.put(SongContract.Song.COL_IMAGE_URI, getImageURI());

        long insertedID = db.insert(SongContract.Song.TABLE_NAME, null, values);
        Toast.makeText(SongDBActivity.this, "" + insertedID, Toast.LENGTH_SHORT).show();


    }


    public String getSongTitle(){
        return etTitle.getText().toString();
    }

    public String getArtist(){
        return etArtist.getText().toString();
    }

    public String getDuration(){
        return etDuration.getText().toString();
    }

    public String getImageURI(){
        return etImageURI.getText().toString();
    }

    public void query(View view) {
    }

    public void update(View view) {
    }

    public void delete(View view) {
    }
}
