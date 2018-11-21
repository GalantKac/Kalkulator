package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class AnimacjaActivity extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animacja);

        imageView = findViewById(R.id.imageView);
        animacjaStart();
    }




    private void animacjaStart()
    {
        Animation animation = new AlphaAnimation(0f,1f);
        animation.setDuration(2000);
        imageView.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                 animation.setFillAfter(true);
                 Intent intent = new Intent(AnimacjaActivity.this,MainActivity.class);
                 startActivity(intent);
                 finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
