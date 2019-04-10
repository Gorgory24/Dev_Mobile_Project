package com.example.testproj5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView scoreLabel;
    private TextView vieLabel;
    private TextView startLabel;
    private ImageView vaisseau;
    private ImageView meteor;
    private ImageView meteor1;
    private ImageView meteor2;
    private ImageView meteor3;
    private ImageView meteor4;

    private int vaisseauX;
    private int meteorX;
    private int meteorY;
    private int meteor1X;
    private int meteor1Y;
    private int meteor2X;
    private int meteor2Y;
    private int meteor3X;
    private int meteor3Y;
    private int meteor4X;
    private int meteor4Y;
    private int ScreenWidth;
    private int ScreenHeight;
    private int FrameWidth;
    private int Vaisseausize;
    private int Meteorsize;
    private int vie = 5;
    private int score = 0;
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private boolean flag;
    private boolean starting = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreLabel = (TextView) findViewById(R.id.score);
        vieLabel = (TextView) findViewById(R.id.vie);
        startLabel = (TextView) findViewById(R.id.Start);
        vaisseau = (ImageView) findViewById(R.id.vaisseau);
        meteor = (ImageView) findViewById(R.id.meteor);
        meteor1 = (ImageView) findViewById(R.id.meteor1);
        meteor2 = (ImageView) findViewById(R.id.meteor2);
        meteor3 = (ImageView) findViewById(R.id.meteor3);
        meteor4 = (ImageView) findViewById(R.id.meteor4);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        ScreenWidth = size.x;
        ScreenHeight = size.y;
        vieLabel.setText("Vie : " + vie);
        scoreLabel.setText("Score : " + score);
        vaisseauX = ScreenWidth / 2;

        meteorX = (int) (Math.random() * ScreenWidth);
        meteor1X = (int) (Math.random() * ScreenWidth);
        meteor2X = (int) (Math.random() * ScreenWidth);
        meteor3X = (int) (Math.random() * ScreenWidth);
        meteor4X = (int) (Math.random() * ScreenWidth);
    }

    public void changePos()
    {
        hitCheck();
        moveMeteor();
        if (meteorY > ScreenHeight)
        {
            meteorY = 0;
            meteorX = (int) Math.floor(Math.random() * (FrameWidth  - meteor.getWidth()));
            score += 1;
            scoreLabel.setText("Score : " + score);
        }

        if (meteor1Y > ScreenHeight)
        {
            meteor1Y = 0;
            meteor1X = (int) Math.floor(Math.random() * (FrameWidth  - meteor1.getWidth()));
            score += 1;
            scoreLabel.setText("Score : " + score);
        }

        if (meteor2Y > ScreenHeight)
        {
            meteor2Y = 0;
            meteor2X = (int) Math.floor(Math.random() * (FrameWidth  - meteor2.getWidth()));
            score += 1;
            scoreLabel.setText("Score : " + score);
        }

        if (meteor3Y > ScreenHeight)
        {
            meteor3Y = 0;
            meteor3X = (int) Math.floor(Math.random() * (FrameWidth  - meteor3.getWidth()));
            score += 1;
            scoreLabel.setText("Score : " + score);
        }

        if (meteor4Y > ScreenHeight)
        {
            meteor4Y = 0;
            meteor4X = (int) Math.floor(Math.random() * (FrameWidth  - meteor4.getWidth()));
            score += 1;
            scoreLabel.setText("Score : " + score);
        }
        meteor.setY(meteorY);
        meteor.setX(meteorX);
        meteor1.setY(meteor1Y);
        meteor1.setX(meteor1X);
        meteor2.setY(meteor2Y);
        meteor2.setX(meteor2X);
        meteor3.setY(meteor3Y);
        meteor3.setX(meteor3X);
        meteor4.setY(meteor4Y);
        meteor4.setX(meteor4X);

        if (flag)
        {
            vaisseauX -=10;
        }
        else
        {
            vaisseauX +=10;
        }

        if (vaisseauX < 0)
        {
            vaisseauX = 0;
        }

        if (vaisseauX > FrameWidth - Vaisseausize)
        {
            vaisseauX = FrameWidth - Vaisseausize;
        }

        vaisseau.setX(vaisseauX);

        vieLabel.setText("Vie : " + vie);
    }

    public void hitCheck()
    {
        int meteorCenterX = meteorX + meteor.getWidth() / 2;
        int meteorCenterY = meteorY + meteor.getHeight() / 2;

        int meteorCenter1X = meteor1X + meteor.getWidth() / 2;
        int meteorCenter1Y = meteor1Y + meteor.getHeight() / 2;

        int meteorCenter2X = meteor2X + meteor.getWidth() / 2;
        int meteorCenter2Y = meteor2Y + meteor.getHeight() / 2;

        int meteorCenter3X = meteor3X + meteor.getWidth() / 2;
        int meteorCenter3Y = meteor3Y + meteor.getHeight() / 2;

        int meteorCenter4X = meteor4X + meteor.getWidth() / 2;
        int meteorCenter4Y = meteor4Y + meteor.getHeight() / 2;



        if (vaisseau.getY() - Vaisseausize/2 <= meteorCenterY + Meteorsize/2
                && meteorCenterY - Meteorsize/2 <= vaisseau.getY() + Vaisseausize/2
                && vaisseauX - Vaisseausize <= meteorCenterX - Meteorsize/2
                && meteorCenterX - Meteorsize/2 <= vaisseauX + Vaisseausize)
        {
            vie -= 1;
            meteorY = 10;
            meteorX = (int) Math.floor(Math.random() * (FrameWidth  - meteor.getWidth()));
        }

        if (vaisseau.getY() - Vaisseausize/2 <= meteorCenter1Y + Meteorsize/2
                && meteorCenter1Y - Meteorsize/2 <= vaisseau.getY() + Vaisseausize/2
                && vaisseauX - Vaisseausize <= meteorCenter1X - Meteorsize/2
                && meteorCenter1X - Meteorsize/2<= vaisseauX + Vaisseausize)
        {
            vie -= 1;
            meteor1Y = 10;
            meteor1X = (int) Math.floor(Math.random() * (FrameWidth  - meteor1.getWidth()));
        }

        if (vaisseau.getY() - Vaisseausize/2 <= meteorCenter2Y + Meteorsize/2
                && meteorCenter2Y - Meteorsize/2 <= vaisseau.getY() + Vaisseausize/2
                && vaisseauX - Vaisseausize <= meteorCenter2X - Meteorsize/2
                && meteorCenter2X - Meteorsize/2 <= vaisseauX + Vaisseausize)
        {
            vie -= 1;
            meteor2Y = 10;
            meteor2X = (int) Math.floor(Math.random() * (FrameWidth  - meteor2.getWidth()));
        }

        if (vaisseau.getY() - Vaisseausize/2 <= meteorCenter3Y + Meteorsize/2
                && meteorCenter3Y - Meteorsize/2 <= vaisseau.getY() + Vaisseausize/2
                && vaisseauX - Vaisseausize <= meteorCenter3X - Meteorsize/2
                && meteorCenter3X - Meteorsize/2 <= vaisseauX + Vaisseausize)
        {
            vie -= 1;
            meteor3Y = 10;
            meteor3X = (int) Math.floor(Math.random() * (FrameWidth  - meteor3.getWidth()));
        }

        if (vaisseau.getY() - Vaisseausize/2 <= meteorCenter4Y + Meteorsize/2
                && meteorCenter4Y - Meteorsize/2 <= vaisseau.getY() + Vaisseausize/2
                && vaisseauX - Vaisseausize <= meteorCenter4X - Meteorsize/2
                && meteorCenter4X - Meteorsize/2 <= vaisseauX + Vaisseausize)
        {
            vie -= 1;
            meteor4Y = 10;
            meteor4X = (int) Math.floor(Math.random() * (FrameWidth  - meteor4.getWidth()));
        }

        if (vie <= 0)
        {
            timer.cancel();
            timer = null;

            Intent intent = new Intent(getApplicationContext(), Scoring.class);
            intent.putExtra("Score", score);
            startActivity(intent);
        }
    }

    public void moveMeteor()
    {
        meteorY += Math.random() * 15 + 5;
        meteor1Y += Math.random() * 15 + 5;
        meteor2Y += Math.random() * 15 + 5;
        meteor3Y += Math.random() * 15 + 5;
        meteor4Y += Math.random() * 15 + 5;
    }

    public boolean onTouchEvent(MotionEvent me) {
        if (starting == false) {

            starting = true;

            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            FrameWidth = frame.getWidth();
            Vaisseausize = vaisseau.getHeight();
            Meteorsize = meteor.getHeight();
            vaisseauX = (int) vaisseau.getX();
            startLabel.setText("");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);
        } else
        {
            if (me.getAction() == MotionEvent.ACTION_DOWN && me.getX() < ScreenWidth / 2)
            {
                flag = true;
            }
            else if (me.getAction() == MotionEvent.ACTION_DOWN && me.getX() > ScreenWidth / 2)
            {
                flag = false;
            }
        }
        return true;
    }
}

