package com.example.nmimsgo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class weather extends AppCompatActivity {

    private TextView tempTextView, weatherTextView;


    private static final String API_KEY = "4a4b9b7ed48277acee3b4defd70ef01e";
    private static final double LATITUDE = 21.3420;
    private static final double LONGITUDE = 74.8826;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather); // Make sure this matches your XML file name

        // Linking views to IDs in your XML
        tempTextView = findViewById(R.id.tempTextView);
        weatherTextView = findViewById(R.id.weatherTextView);


        fetchWeather();
    }

    private String getWeatherUrl() {
        return BASE_URL + "?lat=" + LATITUDE + "&lon=" + LONGITUDE + "&appid=" + API_KEY + "&units=metric";
    }

    private void fetchWeather() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getWeatherUrl(), null,
                response -> {
                    try {
                        JSONObject main = response.getJSONObject("main");
                        double temp = main.getDouble("temp");

                        String description = response.getJSONArray("weather")
                                .getJSONObject(0).getString("description");

                        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

                        // Update UI elements
                        tempTextView.setText(String.format(Locale.getDefault(), "%.0f°C", temp));

                        String output = "Location: NMIMS Shirpur\n" +
                                "Time: " + currentTime + "\n" +
                                "Condition: " + capitalize(description);
                        weatherTextView.setText(output);



                    } catch (JSONException e) {
                        e.printStackTrace();
                        weatherTextView.setText("Error parsing weather data.");
                    }
                },
                error -> {
                    error.printStackTrace();
                    weatherTextView.setText("Failed to retrieve weather data. Please try again.");
                });

        queue.add(request);
    }



    private String capitalize(String input) {
        if (input == null || input.isEmpty()) return "";
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
