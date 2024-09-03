package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TestFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view =  inflater.inflate(R.layout.fragment_test, container, false);
        LinearLayout layao = new LinearLayout(getContext());
        layao.setBackgroundColor(0x20FF0000);

        layao.setOrientation(LinearLayout.VERTICAL);
        //text view
        TextView textView = new TextView(getContext());
        layao.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        textView.setGravity(Gravity.CENTER);
        textView.setText("Thursday");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(34);
//image view
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.cloud);
        layao.addView(textView);
        layao.addView(imageView);


        return layao;
    }
}