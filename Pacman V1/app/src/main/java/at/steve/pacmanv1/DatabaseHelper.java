package at.steve.pacmanv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "highscoreDB";
    private static final String TABLE_HIGHSCORE = "highscoreT";
    private static final String KEY_UUID = "uuid";
    private static final String KEY_HIGHSCORE = "highscore";
    private static final String KEY_DEATHS = "deaths";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HIGHSCORE_TABLE = "CREATE TABLE "+ TABLE_HIGHSCORE+"("
                + KEY_UUID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_HIGHSCORE+" INTEGER,"
                + KEY_DEATHS+" INTEGER"+")";
        db.execSQL(CREATE_HIGHSCORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HIGHSCORE);

        onCreate(db);
    }

    void addHighscore(Highscore highscore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HIGHSCORE, highscore.getHighscore());
        values.put(KEY_DEATHS, highscore.getDeaths());

        db.insert(TABLE_HIGHSCORE, null, values);
        db.close();
    }

    public String getHighscoreString(){
        SQLiteDatabase db = this.getReadableDatabase();

        String command = "SELECT MAX("+KEY_HIGHSCORE+") FROM "+TABLE_HIGHSCORE +" ORDER BY "+KEY_HIGHSCORE +" DESC LIMIT 1";

        Cursor cursor = db.rawQuery(command, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        int score = Integer.parseInt(cursor.getString(0));

        return String.valueOf(score);
    }

    Highscore getHighscore(){
        SQLiteDatabase db = this.getReadableDatabase();

        String command = "SELECT * FROM " +TABLE_HIGHSCORE +" ORDER BY "+KEY_HIGHSCORE +" DESC LIMIT 1;";

        Cursor cursor = db.rawQuery(command, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Highscore highscore = new Highscore(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)));

        return highscore;

    }

    public List<Highscore> getAllHighscores(){
        List<Highscore> highscoreList = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+TABLE_HIGHSCORE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                Highscore highscore = new Highscore();
                highscore.setUuid(Integer.parseInt(cursor.getString(0)));
                highscore.setHighscore(Integer.parseInt(cursor.getString(1)));
                highscore.setDeaths(Integer.parseInt(cursor.getString(2)));

                highscoreList.add(highscore);
            }while (cursor.moveToFirst());
        }

        return highscoreList;
    }

    public  int updateHighscore(Highscore highscore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HIGHSCORE, highscore.getHighscore());
        values.put(KEY_DEATHS, highscore.getDeaths());

        return db.update(TABLE_HIGHSCORE,
                values,
                KEY_UUID+"=?",
                new String[]{String.valueOf(highscore.getUuid())});
    }

    public void deleteHighscore(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HIGHSCORE,null,null);
        db.close();
    }

    public int getDatabaseCount(){
        String countQuery = "SELECT * FROM "+TABLE_HIGHSCORE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(countQuery, null);

        return cursor.getCount();
    }
}
