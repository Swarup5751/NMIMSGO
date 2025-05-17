package com.example.nmimsgo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MapViewActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_map_view);

        mapView = findViewById(R.id.map);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(18.0);

        // Center to Academic Building
        GeoPoint academicBuilding = new GeoPoint(21.2848823, 74.8444529);
        mapView.getController().setCenter(academicBuilding);
    }
}