package com.example.nmimsgo;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Weatheractivity extends AppCompatActivity {
    AutoCompleteTextView autoLecture, autoLab;
    Spinner facultySpinner;
    Button btnFindLecture, btnFindLab, btnFindFaculty;
    TextView lectureRoomInfo, labRoomInfo, facultyRoomInfo;
    RoomDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatheractivity);

        // Initialize views
        autoLecture = findViewById(R.id.autoLecture);
        autoLab = findViewById(R.id.autoLab);
        facultySpinner = findViewById(R.id.facultySpinner);
        btnFindLecture = findViewById(R.id.btnFindLecture);
        btnFindLab = findViewById(R.id.btnFindLab);
        btnFindFaculty = findViewById(R.id.btnFindFaculty);
        lectureRoomInfo = findViewById(R.id.lectureRoomInfo);
        labRoomInfo = findViewById(R.id.labRoomInfo);
        facultyRoomInfo = findViewById(R.id.facultyRoomInfo);

        dbHelper = new RoomDatabaseHelper(this);

        populateSearchableFields();
        populateFacultySpinner();

        btnFindLecture.setOnClickListener(v -> {
            hideKeyboard();
            String room = autoLecture.getText().toString().trim();
            if (!room.isEmpty()) {
                String info = dbHelper.getRoomInfo(room);
                lectureRoomInfo.setText(info != null ? "Room " + room + " is located at:\n" + info : "Lecture room not found.");
            } else {
                lectureRoomInfo.setText("Please select a lecture room.");
            }
        });

        btnFindLab.setOnClickListener(v -> {
            hideKeyboard();
            String lab = autoLab.getText().toString().trim();
            if (!lab.isEmpty()) {
                String info = dbHelper.getRoomInfo(lab);
                labRoomInfo.setText(info != null ? "Lab " + lab + " is located at:\n" + info : "Lab room not found.");
            } else {
                labRoomInfo.setText("Please select a lab room.");
            }
        });

        btnFindFaculty.setOnClickListener(v -> {
            hideKeyboard();
            String faculty = facultySpinner.getSelectedItem().toString().trim();
            if (!faculty.isEmpty()) {
                String info = dbHelper.getFacultyLocation(faculty);
                facultyRoomInfo.setText(info != null ? "Faculty " + faculty + " is located at:\n" + info : "Faculty not found.");
            } else {
                facultyRoomInfo.setText("Please select a faculty.");
            }
        });
    }

    private void populateSearchableFields() {
        List<String> allRooms = dbHelper.getAllRoomNumbers();
        List<String> lrRooms = filterRoomList(allRooms, "LR");
        List<String> labRooms = filterRoomList(allRooms, "LAB");

        ArrayAdapter<String> lrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, lrRooms);
        autoLecture.setAdapter(lrAdapter);

        ArrayAdapter<String> labAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, labRooms);
        autoLab.setAdapter(labAdapter);
    }

    private void populateFacultySpinner() {
        List<String> facultyNames = dbHelper.getAllFacultyNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, facultyNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facultySpinner.setAdapter(adapter);
    }

    private List<String> filterRoomList(List<String> allRooms, String prefix) {
        List<String> filtered = new ArrayList<>();
        for (String room : allRooms) {
            if (room.startsWith(prefix)) {
                filtered.add(room);
            }
        }
        Collections.sort(filtered);
        return filtered;
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}