package org.net.sunger.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyScrollView.ScrollViewListener {
    LinearLayout ll_main;
    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll_content;
    MyScrollView sc_content;
    ImageView iv1;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc_content = (MyScrollView) findViewById(R.id.sc_content);
        ll_main = (LinearLayout) findViewById(R.id.ll_main);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        sc_content.setScrollViewListener(this);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load1(R.id.btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load2(R.id.btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load1(R.id.btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load2(R.id.btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load3(R.id.btn5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load3(R.id.btn6);
            }
        });
        load1(R.id.btn3);
    }

    private void load3(int id) {
        ll_content.removeAllViews();
        View view = LayoutInflater.from(this).inflate(R.layout.item2, null);
        ll_content.addView(view);
    }

    private void load1(int id) {
        ll_content.removeAllViews();
        for (int i = 0; i < 30; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText("jack00" + i);
            ll_content.addView(view);
        }
        if (id == R.id.btn1) {
            sc_content.smoothScrollBy(0, -(sc_content.getScrollY() - top));
        }
    }

    private void load2(int id) {
        ll_content.removeAllViews();
        for (int i = 0; i < 30; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText("rose00" + i);
            ll_content.addView(view);
        }
        if (id == R.id.btn2) {
            sc_content.smoothScrollBy(0, -(sc_content.getScrollY() - top));
        }
    }


    int top;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            top = iv1.getMeasuredHeight() + iv2.getMeasuredHeight();
        }
    }

    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y >= (iv1.getMeasuredHeight() + iv2.getMeasuredHeight())) {
            ll1.setVisibility(View.VISIBLE);
        } else {
            ll1.setVisibility(View.GONE);
        }
    }


}
