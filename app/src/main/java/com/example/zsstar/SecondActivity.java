package com.example.zsstar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private TextView show_name, show_birth, show_xingge;
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        show_name = findViewById(R.id.show_name);
        show_birth = findViewById(R.id.show_birthday);
        show_xingge = findViewById(R.id.show_xingge);
        im = findViewById(R.id.image_show);
        String user_name = getIntent().getStringExtra("name");
        show_name.setText("你好" + user_name);
        int nian = getIntent().getIntExtra("year", 0);
        int yue = getIntent().getIntExtra("month", 0) + 1;
        int ri = getIntent().getIntExtra("day", 0);
        show_birth.setText("你的生日是" + nian + "年" + yue + "月" + ri + "日");

        int[] imgarr = {R.drawable.baiyang, R.drawable.jinniu, R.drawable.shuangzi, R.drawable.juxie,
                        R.drawable.shizi, R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
                        R.drawable.sheshou, R.drawable.mojie, R.drawable.shuiping, R.drawable.shuangyu};
        int[] container = {R.string.白羊座, R.string.金牛座, R.string.双子座, R.string.巨蟹座,
                            R.string.狮子座, R.string.处女座, R.string.天秤座, R.string.天蝎座,
                            R.string.射手座, R.string.摩羯座, R.string.水瓶座, R.string.双鱼座};
        int match = panduan(yue, ri);
        im.setImageResource(imgarr[match]);
        show_xingge.setText(container[match]);
    }

    private int panduan(int bir_month, int bir_day){
        if((bir_month == 3 && bir_day >= 21) || (bir_month == 4 && bir_day <= 19))  return 0;
        else if((bir_month == 4 && bir_day >= 20) || (bir_month == 5 && bir_day <= 20)) return 1;
        else if((bir_month == 5 && bir_day >= 21) || (bir_month == 6 && bir_day <= 21)) return 2;
        else if((bir_month == 6 && bir_day >= 22) || (bir_month == 7 && bir_day <= 22)) return 3;
        else if((bir_month == 7 && bir_day >= 23) || (bir_month == 8 && bir_day <= 22)) return 4;
        else if((bir_month == 8 && bir_day >= 23) || (bir_month == 9 && bir_day <= 22)) return 5;
        else if((bir_month == 9 && bir_day >= 23) || (bir_month == 10 && bir_day <= 23)) return 6;
        else if((bir_month == 10 && bir_day >= 24) || (bir_month == 11 && bir_day <= 22)) return 7;
        else if((bir_month == 11 && bir_day >= 23) || (bir_month == 12 && bir_day <= 21)) return 8;
        else if((bir_month == 12 && bir_day >= 22) || (bir_month == 1 && bir_day <= 19)) return 9;
        else if((bir_month == 1 && bir_day >= 20) || (bir_month == 2 && bir_day <= 18)) return 10;
        else if((bir_month == 2 && bir_day >= 19) || (bir_month == 3 && bir_day <= 20)) return 11;
        else    return -1;
    }
}