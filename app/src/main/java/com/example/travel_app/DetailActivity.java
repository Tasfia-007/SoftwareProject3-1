package com.example.travel_app;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.travel_app.Domains.PopularDomain;


public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt,locationTxt,descriptionTxt,scoreTxt;
    private PopularDomain item;
    ImageView pic,backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        setVariable();
    }

    private void setVariable() {
        item=(PopularDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(item.getTitle());
        scoreTxt.setText(""+(int)item.getScore());
        locationTxt.setText(item.getLocation());
        descriptionTxt.setText(item.getDescription());
        int drawableResId=getResources().getIdentifier(item.getPic(),"drawable",getPackageName());
        Glide.with(this).load(drawableResId).into(pic);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        titleTxt=findViewById(R.id.detailTitleText);
        locationTxt=findViewById(R.id.locationTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        pic=findViewById(R.id.imageView);
        backBtn=findViewById(R.id.backarrow);
    }
}