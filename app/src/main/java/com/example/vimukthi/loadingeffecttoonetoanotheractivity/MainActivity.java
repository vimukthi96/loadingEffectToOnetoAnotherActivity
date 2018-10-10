package com.example.vimukthi.loadingeffecttoonetoanotheractivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import cc.cloudist.acplibrary.ACProgressPie;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private static final int SPLASH_TIME = 2* 1000;// 3 seconds delay
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACProgressFlower dialog = new ACProgressFlower.Builder(MainActivity.this)
                        .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                        .themeColor(Color.WHITE)
                        .text("Loading..")
                        .fadeColor(Color.DKGRAY).build();
                dialog.show();
                try {
                    new Handler().postDelayed(new Runnable() {

                        public void run() {

                            Intent intent = new Intent(MainActivity.this,
                                    SecondActivity.class);
                            startActivity(intent);

                            MainActivity.this.finish();
                        }
                    }, SPLASH_TIME);
                } catch (Exception e) {
                }
            }
        });

    }
}
