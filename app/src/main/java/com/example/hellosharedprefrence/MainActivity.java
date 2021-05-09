package com.example.hellosharedprefrence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hellosharedprefrence.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Create quantity..
    int  quantity = 0;
    // Create color..
    int mcolor;
    // Create activity main binding..
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        quantity = preferences.getInt(Constants.QUANTITY_KEY,0);
        mcolor = preferences.getInt(Constants.COLOR_KEY,R.color.Default);


        b.qty.setText(String.valueOf(quantity));
        b.qty.setBackgroundColor(mcolor);
    }
 /// Count method..
 public void Count(View view) {
        b.qty.setText("" + ++ quantity);
    }

    //SET THE BACKGROUND COLOR OF THE COUNT...

    // Set the color as dark...
    public void Black(View view) {
        mcolor = getResources().getColor(R.color.black);
        b.qty.setBackgroundColor(mcolor);
    }
    // Set the color as Red..
    public void Red(View view) {
        mcolor = getResources().getColor(R.color.Red);
        b.qty.setBackgroundColor(mcolor);
    }
    // Set the color as Blue..
    public void Blue(View view) {
        mcolor = getResources().getColor(R.color.blue);
        b.qty.setBackgroundColor(mcolor);
    }
    // Set the color as Green..
    public void Green(View view) {
        mcolor = getResources().getColor(R.color.Green);
        b.qty.setBackgroundColor(mcolor);
    }


    // Reset the count to 0 and color to default color..
    public void Reset(View view) {
        quantity = 0;
        b.qty.setText(""+quantity);
        mcolor = ContextCompat.getColor(this,R.color.Default);
        b.qty.setBackgroundColor(mcolor);
    }
    // Override the on pause method..
    @Override
    protected void onPause() {
        super.onPause();
        ///  Create the shared prefernces object...
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        preferences.edit()
                .putInt(Constants.QUANTITY_KEY,quantity)
                .putInt(Constants.COLOR_KEY,mcolor)
                .apply();
    }
}







