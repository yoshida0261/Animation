package com.yoshida261.animation.app;

import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
       // animateAlpha(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateJump(view);
            }
        });

    }

    private void animateJump(View target){

        int delay = 380;
        //jum 1
        ObjectAnimator jump1_up = ObjectAnimator.ofFloat( target, "translationY", 0f, -200f );
        jump1_up.setDuration(300);
        jump1_up.start();

        ObjectAnimator jump1_down = ObjectAnimator.ofFloat( target, "translationY", -200f, 0f );
        jump1_down.setDuration(400);
        jump1_down.setStartDelay(delay);// 滞空時間を考慮してちょっとあとに落ちてくる
        jump1_down.start();

        ObjectAnimator jump2_up = ObjectAnimator.ofFloat( target, "translationY", 0f, -70f );
        jump2_up.setDuration(500);
        delay += 380;
        jump2_up.setStartDelay(delay);
        jump2_up.start();

        ObjectAnimator jump2_down = ObjectAnimator.ofFloat( target, "translationY", -70f, 0f );
        jump2_down.setDuration(500);
        delay += 550;
        jump2_down.setStartDelay(delay);// 滞空時間を考慮してちょっとあとに落ちてくる
        jump2_down.start();





    }

    private void animateAlpha( Button target ) {

        // alphaプロパティを0fから1fに変化させます
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, "alpha", 0f, 1f);

        // 3秒かけて実行させます
        objectAnimator.setDuration( 3000 );

        // アニメーションを開始します
        objectAnimator.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
