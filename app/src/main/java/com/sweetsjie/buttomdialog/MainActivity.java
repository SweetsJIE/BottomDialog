package com.sweetsjie.buttomdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sweetsjie.buttomdialog.util.DensityUtil;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(true);       //点击空白区域关闭
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_show_2);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        //设置标题
        toolbar.setTitle("BottomDialog");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().set

        button.setOnClickListener(new btListener());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //toolbar的menu点击事件的监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this,"main",Toast.LENGTH_SHORT).show();
                        show2();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this,"share",Toast.LENGTH_SHORT).show();
                        break;
                }
                return  true;
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);//加载menu文件到布局

        return true;
    }

//    private void show1() {
//        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
//        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
//        bottomDialog.setContentView(contentView);
//        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
//        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
//        contentView.setLayoutParams(layoutParams);
//        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
//        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
//        bottomDialog.show();
//    }

    private void show2() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_circle, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 16f);
        params.bottomMargin = DensityUtil.dp2px(this, 8f);
        contentView.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        //点击空白关闭
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.setCancelable(true);

        bottomDialog.show();
    }

    public void test(View v){
        Toast.makeText(MainActivity.this,"delete",Toast.LENGTH_SHORT).show();
    }

    private class btListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_show_2:{
                    show2();
                    break;
                }
            }
        }
    }
}
