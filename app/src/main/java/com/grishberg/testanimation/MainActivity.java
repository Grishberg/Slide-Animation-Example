package com.grishberg.testanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.grishberg.testanimation.framework.AnimationHelper;
import com.grishberg.testanimation.views.CustomView;

public class MainActivity extends AppCompatActivity {

    private Button btnOpen;
    private FrameLayout customViewHolder;
    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customViewHolder = (FrameLayout) findViewById(R.id.panelContainer);
        customView = new CustomView(this);
        customView.add(customViewHolder);
        customView.setVisibility(View.GONE);

        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOpen.setVisibility(View.GONE);
                AnimationHelper.slide(MainActivity.this, customView);
            }
        });
    }
}
