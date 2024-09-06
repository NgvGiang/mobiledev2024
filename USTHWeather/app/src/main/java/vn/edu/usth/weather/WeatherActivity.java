package vn.edu.usth.weather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportFragmentManager().beginTransaction().add(R.id.forecast_container,new ForecastFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.weather_fragment,new WeatherFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("WeatherActivity","Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("WeatherActivity","Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("WeatherActivity","Activity Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("WeatherActivity","Activity Destroyed");
    }
}