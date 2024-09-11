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
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        //add 3 same fragments. will modify later
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Paris");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"HaNoi");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"London");
        //header sync with tabLayout
        viewPager2.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(viewPagerAdapter.getTitle(position));
        }).attach();
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