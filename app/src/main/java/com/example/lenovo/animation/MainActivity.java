  package com.example.lenovo.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

  public class MainActivity extends AppCompatActivity {

      private float translationY;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image=findViewById(R.id.image);
         // translationY = image.getTranslationY();
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(image, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(image, "scaleX", 0.0f, 2.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(image, "scaleY", 0.0f, 2.0f);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(image, "rotation", 0, 360);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(image, "translationX", 0, 0);

        ObjectAnimator transYAnim= ObjectAnimator.ofFloat(image, "translationY",10,500);


        AnimatorSet set = new AnimatorSet();
        set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
//                set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);




        set.setDuration(5000);
        set.start();
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        };
        timer.schedule(task,5000);
    }
}
