package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("SecondActivity","Activity Created");
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout,new TestFragment()).commit();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SecondActivity","Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondActivity","Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SecondActivity","Activity Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SecondActivity","Activity Destroyed");
    }
}