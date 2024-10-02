package vn.edu.usth.weather;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private Handler handler;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        //add 3 same fragments. will modify later
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),getString(R.string.hanoi));
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),getString(R.string.berlin));
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),getString(R.string.london));
        //header sync with tabLayout
        viewPager2.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(viewPagerAdapter.getTitle(position));
        }).attach();

        //Handler in main thread
        handler = new Handler(Looper.getMainLooper()){
            public void handleMessage(Message msg){
                //do something
                String content = msg.getData().getString("server_response");
                //Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(android.R.id.content),content, Snackbar.LENGTH_SHORT).show();
            }
        };

        //create second thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                //do some thing
                try {
                // wait for 5 seconds to simulate a long network access
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Send a message to the handler
                // Assume that we got our data from server
                Bundle bundle = new Bundle();
                bundle.putString("server_response","some json here");
                // notify main thread
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }).start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            simulateNetworkRequest();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void simulateNetworkRequest() {
        new Thread(() -> {
            try {
                Thread.sleep(5000); // Simulate network delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString("server_response", "Data refreshed");
            Message msg = new Message();
            msg.setData(bundle);
            handler.sendMessage(msg);
        }).start();
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