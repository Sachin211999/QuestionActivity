package com.example.questionactivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
SliderAdapter sliderAdapter;
Button next,previous;
int sum=0;
float val;
int val1;
int currentpage;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
viewPager=(ViewPager)findViewById(R.id.viewpager);
        next=(Button) findViewById(R.id.next);
      sliderAdapter=new SliderAdapter(this);
        final RatingBar ratingBar = findViewById(R.id.rate);
        tv = findViewById(R.id.tv);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentpage==10-1)
                {
                    sum+=val1;
                    Intent intent=new Intent(MainActivity.this,Dashboard.class);
                    intent.putExtra("sum",sum);
                    startActivity(intent);
                }
                else {
                    float val = Float.parseFloat(tv.getText().toString() );
                    val1=(int)val;
                    sum+=val1;
                    viewPager.setCurrentItem(currentpage + 1);
                    ratingBar.setRating(0.0f);
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("uuu", ratingBar.getRating() + "");
                tv.setText(String.valueOf((int) ratingBar.getRating()));
            }
        });




    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
             currentpage = position;
            if(position==0)
            {
                next.setEnabled(true);
                next.setText("Next");

            }
            else if(position == 10-1)
            {

                next.setEnabled(true);
                next.setText("Finish");


            }
            else
            {

                next.setEnabled(true);
                next.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}