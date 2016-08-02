package tomerbu.edu.songdbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stud27 on 02/08/16.
 */
public class SongDBHelper extends SQLiteOpenHelper {

    //Constructor
    public SongDBHelper(Context context) {
        super(context, "SongDB", null, 1);
    }

    //Methods that we need to implement:
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTable = "CREATE TABLE Songs(" +
                                                        "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                                                        "title TEXT NOT NULL, " +
                                                        "artist TEXT, " +
                                                        "duration TEXT, " +
                                                        "imageUri TEXT " +
                                                    ");";

        db.execSQL(createSongTable);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropSongs = "DROP TABLE Songs;";
        db.execSQL(dropSongs);

        onCreate(db);
    }
}
