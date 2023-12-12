package com.example.doctohtml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.poi.org.work2html.RBQWordManager;
import com.poi.org.work2html.WordUtils;
import com.poi.org.work2html.BasicSet;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 定义请求码常量
    private static final int REQUEST_CODE = 1;

    Button bnConver,bnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnConver = findViewById(R.id.bn_conver);
        bnDelete = findViewById(R.id.bn_delete);
        bnConver.setOnClickListener(this);
        bnDelete.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        if (v==bnConver){
            // 定义一个权限数组
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            // 定义一个标志变量，表示是否所有权限都已授予
            boolean allGranted = true;
            // 遍历权限数组，检查每个权限的状态
            for (String permission : permissions) {
                // 如果有任何一个权限被拒绝，就将标志变量设为false，并跳出循环
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }
            // 根据标志变量的值，执行相应的操作
            if (!allGranted) {
                // 如果有任何一个权限被拒绝，就请求权限
                ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE);

            } else {
                // 如果所有权限都已授予，就执行您的功能

                new Thread(new Runnable() {
                    @Override
                    public void run() {

//                        File file = new File(Environment.getExternalStorageDirectory(), "20230109.docx");
//                        String sourceFilePath = file.getAbsolutePath();
//                        Log.i("RBQ","源文件路径为:"+sourceFilePath);
//                        String htmlFilePath = Environment.getExternalStorageDirectory() + "/html";
//
//                        String htmlFileName = "20230109";
//                        BasicSet basicSet = new BasicSet(
//                                MainActivity.this,
//                                sourceFilePath,//源文件
//                                htmlFilePath,//保存后的文件路径
//                                htmlFileName);//保存后的文件名称
//                        //BasicSet 基础设置
//                        //可以修改标签样式等 具体看BasicSet的属性
//                        //如：取消网页自适应手机屏幕
//                        //String htmlBegin =
//                        //        "<!DOCTYPE html>" +
//                        //                "<html>" +
//                        //                "<head>" +
//                        //                "</head>" +
//                        //                "<body>";
//                        //basicSet.setHtmlBegin(htmlBegin);
//                        String htmlSavePath = WordUtils.getInstance(basicSet).word2html();
//                        //跳转到webview界面预览转换html文件
//                        Intent i = new Intent(MainActivity.this,PreviewActivity.class);
//                        i.putExtra("path",htmlSavePath);
//                        startActivity(i);

                        File file = new File(Environment.getExternalStorageDirectory(), "20230109.docx");
                        String sourceFilePath = file.getAbsolutePath();
                        Log.i("RBQ","源文件路径为:"+sourceFilePath);
//                        String htmlFilePath = getFilesDir() + "/html";
                        String htmlFilePath = getFilesDir() + "/html/20230109.html";

//                        String htmlFileName = "20230109";
//                        BasicSet basicSet = new BasicSet(
//                                WorkActivity.this,
//                                sourceFilePath,//源文件
//                                htmlFilePath,//保存后的文件路径
//                                htmlFileName);//保存后的文件名称
//                        String htmlSavePath = WordUtils.getInstance(basicSet).word2html();
                        RBQWordManager wordManager = new RBQWordManager();
                        String htmlSavePath = wordManager.wordToHtml(sourceFilePath,htmlFilePath);
                        Log.d("RBQ", "htmlSavePath:"+htmlSavePath);

                        //跳转到webview界面预览转换html文件
                        Intent i = new Intent(MainActivity.this,PreviewActivity.class);
                        i.putExtra("path",htmlSavePath);
                        startActivity(i);

                    }
                }).start();


            }

        }

    }
}