package com.example.nmimsgo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity_1 extends AppCompatActivity {
    MapView map;
    HashMap<String, GeoPoint> locations = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set user agent for osmdroid
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main_1);

        map = findViewById(R.id.map);
        map.setMultiTouchControls(true);
        map.getController().setZoom(18.0);

        // Define location points
        locations.put("Nmims_Main_Gate", new GeoPoint(21.2856659, 74.8459462));
        locations.put("Academic_Building", new GeoPoint(21.2848823, 74.8444529));
        locations.put("Girl_Hostel", new GeoPoint(21.2845493, 74.8430862));
        locations.put("Old_Boys_Hostel", new GeoPoint(21.2863223, 74.8424939));
        locations.put("New_Boys_Hostel", new GeoPoint(21.2856692, 74.8410620));

        // Get selected points from Intent extras
        String start = getIntent().getStringExtra("start_location");
        String end = getIntent().getStringExtra("end_location");

        if (locations.containsKey(start) && locations.containsKey(end)) {
            GeoPoint startPoint = locations.get(start);
            GeoPoint endPoint = locations.get(end);
            fetchAndDrawRoute(startPoint, endPoint);
        }
    }

    private void fetchAndDrawRoute(GeoPoint start, GeoPoint end) {
        RouteFetcher.getRoute(this, start, end, new RouteFetcher.RouteCallback() {
            @Override
            public void onRouteFetched(ArrayList<GeoPoint> routePoints) {
                Polyline line = new Polyline();
                line.setPoints(routePoints);
                line.setColor(android.graphics.Color.BLUE);
                line.setWidth(10f);

                map.getOverlays().clear();
                map.getOverlays().add(line);
                map.getController().setCenter(start);
                map.invalidate();
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(MainActivity_1.this, "Route error: " + errorMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
