package com.example.questionactivity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    SliderAdapter(Context context)
    {
        this.context=context;
    }
    private int[] slideimages={
      R.drawable.fever,
      R.drawable.sneeze,
            R.drawable.shortnessofbreath,
            R.drawable.headaches,R.drawable.achesandpain,R.drawable.fatigue,R.drawable.runnynose,R.drawable.diarrhea,R.drawable.cough,R.drawable.sorethroat
    };
    private String[] slidequestions ={
            "FEVER","SNEEZING","SHORTNESS OF BREATH","HEADACHES","ACHES AND PAIN","FATIGUE","RUNNY NOSE","DIARRHEA","COUGH","SORE THROAT"
             };
    @Override
    public int getCount() {
        return slidequestions.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView questions=(TextView)view.findViewById(R.id.questions);
        imageView.setImageResource(slideimages[position]);
        questions.setText(slidequestions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}