package com.example.he.materialdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        button= (Button) findViewById(R.id.b);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5.0以上的跳转动画
                getWindow().setExitTransition(new Explode());
                Intent intent=new Intent(MainActivity.this,SecondAcitvity.class);
                //执行跳转动画
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

    }
}
