package com.example.a51animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int menu_alpha_id = 1;
    final int menu_scale_id = 2;
    final int menu_translate_id = 3;
    final int menu_rotate_id= 4;
    final int menu_combo_id = 5;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        // регистрируем контекстное меню для компонента tv
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                       ContextMenuInfo menuInfo){
        switch (v.getId()){
            case R.id.tv:
                menu.add(0, menu_alpha_id, 0, "alpha");
                menu.add(0, menu_scale_id, 0, "scale");
                menu.add(0, menu_translate_id, 0, "translate");
                menu.add(0, menu_rotate_id, 0, "rotate");
                menu.add(0, menu_combo_id, 0, "combo");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        Animation anim = null;

        switch (item.getItemId()){
            case menu_alpha_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case menu_scale_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case menu_translate_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case menu_rotate_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case menu_combo_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}