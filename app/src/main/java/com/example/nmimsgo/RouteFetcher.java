package com.example.nmimsgo;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RouteFetcher {

    private static final String TAG = "RouteFetcher";
    private static final String API_KEY = "5b3ce3597851110001cf6248b55c6b1900b94ea0bc18fb0c3f6e61c3";

    public interface RouteCallback {
        void onRouteFetched(ArrayList<GeoPoint> routePoints);
        void onError(String errorMessage);
    }

    public static void getRoute(Context context, GeoPoint start, GeoPoint end, RouteCallback callback) {
        try {
            String url = "https://api.openrouteservice.org/v2/directions/foot-walking/geojson";

            // Prepare JSON body
            JSONObject jsonBody = new JSONObject();
            JSONArray coordinates = new JSONArray();

            JSONArray startCoord = new JSONArray();
            startCoord.put(start.getLongitude());
            startCoord.put(start.getLatitude());

            JSONArray endCoord = new JSONArray();
            endCoord.put(end.getLongitude());
            endCoord.put(end.getLatitude());

            coordinates.put(startCoord);
            coordinates.put(endCoord);
            jsonBody.put("coordinates", coordinates);

            // Create JSON request
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonBody,
                    response -> {
                        try {
                            ArrayList<GeoPoint> points = new ArrayList<>();
                            JSONArray coords = response
                                    .getJSONArray("features")
                                    .getJSONObject(0)
                                    .getJSONObject("geometry")
                                    .getJSONArray("coordinates");

                            for (int i = 0; i < coords.length(); i++) {
                                JSONArray coord = coords.getJSONArray(i);
                                double lon = coord.getDouble(0);
                                double lat = coord.getDouble(1);
                                points.add(new GeoPoint(lat, lon));
                            }

                            callback.onRouteFetched(points);
                        } catch (Exception e) {
                            callback.onError("Parsing error: " + e.getMessage());
                        }
                    },
                    error -> {
                        callback.onError("Request error: " + error.getMessage());
                        Log.e(TAG, "Volley error: ", error);
                    }
            ) {
                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", API_KEY);
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };

            // Add request to queue
            RequestQueue queue = Volley.newRequestQueue(context);
            queue.add(request);

        } catch (Exception e) {
            callback.onError("Exception: " + e.getMessage());
        }
    }
}
