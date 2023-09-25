package com.example.dowchemicalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataStorage extends SQLiteOpenHelper {

    private static List<Project> projectlist = new ArrayList<>();


    private static DataStorage dsref;

    public DataStorage(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, Integer version) {
        super(context, name, factory, version);
    }

    public static DataStorage getInstance(){
        if (dsref == null){
            dsref = new DataStorage(null,null,null,null);
        }
        return dsref;
    }

    public static List<Project> getProject() {
        List<Project> copy = new ArrayList<>();
        copy.addAll(projectlist);
        return copy;
    }

    public static void deleteProject(Project newproject) {
        projectlist.remove(newproject);
    }


    private static final class projectTable {

        private static final String TABLE = "Projects";
        private static final String COL_EMAILS = "emails";

        private static final String COL_CREATOR = "creator";
        private static final String COL_DESCRIPTION = "creator";
        private static final String COL_COWORKERS = "coworkers";
        private static final String COL_DATES = "dates";




    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ projectTable.TABLE + "(" +
                projectTable.COL_EMAILS + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        
    }


    public static void addProject(Project newproject) {
        SQLiteDatabase sqldb = DataStorage.dsref.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(projectTable.COL_EMAILS, newproject.getEmail().toString());
        values.put(projectTable.COL_CREATOR, newproject.getCreator().toString());
        values.put(projectTable.COL_COWORKERS, newproject.getCoworkers().toString());
        values.put(projectTable.COL_DESCRIPTION, newproject.getDescription().toString());
        sqldb.insert(projectTable.TABLE, null, values);
    }

}


