package com.example.day10;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.day10.fargmnet.BlankFragment;
import com.example.day10.fargmnet.BlankFragment2;
import com.example.day10.fargmnet.BlankFragment3;
import com.example.day10.fargmnet.BlankFragment4;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fr;
    private BottomNavigationView bnv001;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fr = findViewById(R.id.fr);

        BottomNavigationView bnv_001 = (BottomNavigationView) findViewById(R.id.bnv_001);

        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fr,blankFragment)
                .add(R.id.fr,blankFragment2)
                .add(R.id.fr,blankFragment3)
                .add(R.id.fr,blankFragment4)
                .show(blankFragment)
                .hide(blankFragment2)
                .hide(blankFragment3)
                .hide(blankFragment4)
                .commit();
        //为底部导航设置条目选中监听
        bnv_001.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(
                    @NonNull
                            MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_one:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case R.id.item_two:
                        getSupportFragmentManager().beginTransaction()
                                .hide(blankFragment)
                                .show(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case R.id.item_san:
                        getSupportFragmentManager().beginTransaction()
                                .hide(blankFragment)
                                .hide(blankFragment2)
                                .show(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case R.id.item_si:
                        getSupportFragmentManager().beginTransaction()
                                .hide(blankFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .show(blankFragment4)
                                .commit();
                        break;
                }

                return true;    //这里返回true，表示事件已经被处理。如果返回false，为了达到条目选中效果，还需要下面的代码
                // item.setChecked(true);  不论点击了哪一个，都手动设置为选中状态true（该控件并没有默认实现)
                // 。如果不设置，只有第一个menu展示的时候是选中状态，其他的即便被点击选中了，图标和文字也不会做任何更改

            }
        });

        //默认选中底部导航栏中的第三个
        bnv_001.getMenu().getItem(0).setChecked(true);

    }




}
