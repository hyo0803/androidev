package com.example.eye;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView exerInfo, timerTV;
    ImageView Dot;
    Button btnStart;
    Animation animStart, animDown, animUp, animLeft, animRight, animBack;
    Animation animUpRight, animRightDown, animDownLeft, animLeftUp, animBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTV = (TextView) findViewById(R.id.timer);
        exerInfo = (TextView) findViewById(R.id.info);
        btnStart = (Button) findViewById(R.id.btnSt);
        Dot = (ImageView) findViewById(R.id.dot);

        btnStart.setOnClickListener(this);
    }

    void DownUpLeftRight(){
        animStart = AnimationUtils.loadAnimation(this, R.anim.startup);
        animDown = AnimationUtils.loadAnimation(this, R.anim.down);
        animUp = AnimationUtils.loadAnimation(this, R.anim.up);
        animLeft = AnimationUtils.loadAnimation(this, R.anim.left);
        animRight = AnimationUtils.loadAnimation(this, R.anim.right);
        animBack = AnimationUtils.loadAnimation(this, R.anim.fromright);

        animUpRight = AnimationUtils.loadAnimation(this, R.anim.uptoright);
        animRightDown = AnimationUtils.loadAnimation(this, R.anim.rightdown);
        animDownLeft = AnimationUtils.loadAnimation(this, R.anim.downtoleft);
        animLeftUp = AnimationUtils.loadAnimation(this, R.anim.leftup);
        animBack2 = AnimationUtils.loadAnimation(this, R.anim.back2);

        animStart.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>3){
                    Dot.clearAnimation();
                    animStart.cancel();
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (x<3){
                    Dot.startAnimation(animDown);
                }else if (x==3){
                    Dot.startAnimation(animUpRight);
                }
                Dot.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                animStart.setRepeatCount(3);
            }
        });
        animDown.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x > 2) {
                    Dot.clearAnimation();
                    animDown.cancel();
                }
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animUp);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animUp.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animUp.cancel();}
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animLeft);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animLeft.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animLeft.cancel();}
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animRight);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animRight.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animRight.cancel();}
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animBack);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animBack.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                //x++;
                Dot.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                x++;
                if (x==1){
                    animStart.setStartOffset(200);
                    Dot.startAnimation(animStart);
                }else if (x==2){
                    animStart.setStartOffset(5000);
                    Dot.startAnimation(animStart);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });

        animUpRight.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x > 2) {
                    Dot.clearAnimation();
                    animUpRight.cancel();
                    Dot.startAnimation(animBack2);
                }
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animRightDown);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                animUpRight.setRepeatCount(2);
            }
        });
        animRightDown.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animRightDown.cancel();}
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animDownLeft);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animDownLeft.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animDown.cancel();}
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animLeftUp);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        animLeftUp.setAnimationListener(new Animation.AnimationListener() {
            int x = 0;
            @Override
            public void onAnimationStart(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
                x++;
                if (x>2){
                    Dot.clearAnimation();
                    animLeftUp.cancel();}
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Dot.startAnimation(animUpRight);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Dot.setVisibility(View.VISIBLE);
            }
        });
        Dot.startAnimation(animStart);
    }

    @Override
    public void onClick(View v) {
        new CountDownTimer(40000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished>20000){
                    timerTV.setText(millisUntilFinished / 1000+"s");
                    exerInfo.setText("Exercise: "+1);
                }else if (20000>=millisUntilFinished && millisUntilFinished>=15000){
                    timerTV.setText((millisUntilFinished / 1000-15)+"s");
                    exerInfo.setText("Break");
                }else if (millisUntilFinished<15000){
                    timerTV.setText(millisUntilFinished / 1000+"s");
                    exerInfo.setText("Exercise: "+2);
                }
            }
            public void onFinish() {
                timerTV.setText("Done!");
            }
        }.start();
        DownUpLeftRight();
    }
}