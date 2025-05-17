package com.example.nmimsgo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CampusRooms.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_ROOMS = "rooms";
    private static final String COLUMN_ROOM_NUMBER = "room_number";
    private static final String COLUMN_BLOCK = "block";
    private static final String COLUMN_FLOOR = "floor";
    private static final String COLUMN_DIRECTION = "direction";

    private static final String TABLE_FACULTY = "faculty";
    private static final String COLUMN_FACULTY_NAME = "faculty_name";
    private static final String COLUMN_FACULTY_ROOM = "faculty_room";

    public RoomDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ROOMS_TABLE = "CREATE TABLE " + TABLE_ROOMS + "("
                + COLUMN_ROOM_NUMBER + " TEXT PRIMARY KEY,"
                + COLUMN_BLOCK + " TEXT,"
                + COLUMN_FLOOR + " INTEGER,"
                + COLUMN_DIRECTION + " TEXT)";
        db.execSQL(CREATE_ROOMS_TABLE);

        String CREATE_FACULTY_TABLE = "CREATE TABLE " + TABLE_FACULTY + "("
                + COLUMN_FACULTY_NAME + " TEXT PRIMARY KEY,"
                + COLUMN_FACULTY_ROOM + " TEXT)";
        db.execSQL(CREATE_FACULTY_TABLE);

        // Lecture Rooms
        db.execSQL("INSERT INTO rooms VALUES ('LR1', 'B Wing', 0, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR2', 'B Wing', 0, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR3', 'B Wing', 0, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR4', 'B Wing', 0, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR5', 'B Wing', 0, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR6', 'B Wing', 1, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR7', 'B Wing', 1, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR8', 'B Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR9', 'B Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR10', 'B Wing', 2, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR11', 'B Wing', 2, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR12', 'B Wing', 2, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR13', 'B Wing', 2, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR14', 'C Wing', 1, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR15', 'C Wing', 1, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR16', 'C Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR17', 'C Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR18', 'C Wing', 2, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LR19', 'C Wing', 2, 'Right Side')");

        // Labs (Updated Names)
        db.execSQL("INSERT INTO rooms VALUES ('ACN LAB', 'D Wing', 0, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('PR LAB', 'D Wing', 0, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('SS LAB', 'D Wing', 1, 'Left Side')");

        db.execSQL("INSERT INTO rooms VALUES ('LAB4', 'B Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB5', 'B Wing', 2, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB6', 'B Wing', 2, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB7', 'C Wing', 1, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB8', 'C Wing', 1, 'Right Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB9', 'C Wing', 2, 'Left Side')");
        db.execSQL("INSERT INTO rooms VALUES ('LAB10', 'C Wing', 2, 'Right Side')");

        // Faculty
        db.execSQL("INSERT INTO faculty VALUES ('Prof. Rithesh Dhanare', 'C wing, 2nd Floor, Left side')");
        db.execSQL("INSERT INTO faculty VALUES ('Prof. Dhiraj Bise', 'C wing, 2nd Floor, Right side')");
        db.execSQL("INSERT INTO faculty VALUES ('Prof. Praveen Langde', 'C wing, 2nd Floor, Right side')");
        db.execSQL("INSERT INTO faculty VALUES ('Prof. Sonia Relan', 'C wing, 2nd Floor, Right side')");
        db.execSQL("INSERT INTO faculty VALUES ('Prof. Pratiskha Mishram', 'B wing, 1st Floor, Left side')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACULTY);
        onCreate(db);
    }

    public String getRoomInfo(String roomNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ROOMS, null, COLUMN_ROOM_NUMBER + "=?",
                new String[]{roomNumber}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String block = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BLOCK));
            int floor = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_FLOOR));
            String direction = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIRECTION));
            cursor.close();
            return block + ", " + getFloorSuffix(floor) + " Floor, " + direction;
        }
        return null;
    }

    private String getFloorSuffix(int floor) {
        switch (floor) {
            case 0: return "Ground";
            case 1: return "1st";
            case 2: return "2nd";
            case 3: return "3rd";
            default: return floor + "th";
        }
    }

    public List<String> getAllRoomNumbers() {
        List<String> roomList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ROOM_NUMBER + " FROM " + TABLE_ROOMS, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                roomList.add(cursor.getString(0));
            }
            cursor.close();
        }
        return roomList;
    }

    public String getFacultyRoomInfo(String facultyName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FACULTY, null, COLUMN_FACULTY_NAME + "=?",
                new String[]{facultyName}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String facultyRoom = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FACULTY_ROOM));
            cursor.close();
            return facultyRoom;
        }
        return null;
    }

    public String getFacultyLocation(String facultyName) {
        return getFacultyRoomInfo(facultyName);
    }

    public List<String> getAllFacultyNames() {
        List<String> facultyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_FACULTY_NAME + " FROM " + TABLE_FACULTY, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                facultyList.add(cursor.getString(0));
            }
            cursor.close();
        }
        return facultyList;
    }
}
