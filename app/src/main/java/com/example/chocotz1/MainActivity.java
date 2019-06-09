package com.example.chocotz1;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button button;
    private ProgressBar pb;
    private Handler handler;
    Timer timer;
    Runnable r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);



        handler = new Handler();
        button = findViewById(R.id.button_book);
        final Intent intent = new Intent(this, BookListActivity.class);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.INVISIBLE);
                pb.setVisibility(View.VISIBLE);
                r = new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.GONE);
                        timer.cancel();

                        startActivity(intent);
                    }
                };
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(r);
                    }
                }, 3000, 300);

            }
        });
    }
}
