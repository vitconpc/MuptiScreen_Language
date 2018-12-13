package vn.com.example.multiple_languge.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import vn.com.example.multiple_languge.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnglish;
    private Button btnVietNamese;
    private Button btnHello;
    private Button btnGoodbye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }

    private void setEvent() {
        btnEnglish.setOnClickListener(this);
        btnVietNamese.setOnClickListener(this);
        btnHello.setOnClickListener(this);
        btnGoodbye.setOnClickListener(this);
    }

    private void initView() {
        btnHello = findViewById(R.id.btn_hello);
        btnGoodbye = findViewById(R.id.btn_goodbye);
        btnVietNamese = findViewById(R.id.btn_vietnamese);
        btnEnglish = findViewById(R.id.btn_english);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        Configuration config = new Configuration();
        switch (v.getId()) {
            case R.id.btn_english: {
                config.setLocale(new Locale(Locale.ENGLISH.getLanguage()));
            }
            break;
            case R.id.btn_vietnamese: {
                config.setLocale(new Locale("vi","VN"));
            }
            break;
            case R.id.btn_goodbye: {
                Toast.makeText(this, R.string.say_goodbye, Toast.LENGTH_SHORT).show();
            }
            break;
            default: {
                Toast.makeText(this, R.string.say_hello, Toast.LENGTH_SHORT).show();
            }
            break;
        }
        changeLocate(config);
    }

    private void changeLocate(Configuration config) {
        getBaseContext().getResources()
                .updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
