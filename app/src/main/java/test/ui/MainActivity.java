package test.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dzh.serversup.R;

import test.Beantest;
import test.TPPresenter;
import test.TPView;

public class MainActivity extends AppCompatActivity {
    public TPPresenter tpPresenter;
    private TextView t;
    private String[] str = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.text);
        tpPresenter = new TPPresenter(this, new TPView() {
            @Override
            public void onSuccess(Beantest beantest) {
//             t.setText();
            }

            @Override
            public void onError() {

            }
        });
        tpPresenter.getInfo();




    }
}
