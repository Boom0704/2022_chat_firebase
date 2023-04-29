package com.example.chat01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //로그인 세션 유지
        Intent intent = getIntent();
        final String userId = intent.getExtras().getString("userId");
        TextView testId =(TextView) findViewById(R.id.testId);
        testId.setText(userId);

        EditText editNewId =(EditText) findViewById(R.id.editNewId);
        Button btnAddNewFriend =(Button) findViewById(R.id.btnAddNewFriend);
        Button btnHome =(Button) findViewById(R.id.btnHome);
        Button btnChatList =(Button) findViewById(R.id.btnChatList);
        Button btnSetting =(Button) findViewById(R.id.btnSetting);

        btnAddNewFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("친구 추가"); //제목
                dlg.setMessage("친구추가 결과."); // 메시지

                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(MainActivity.this,"확인을 눌르셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("userId", userId);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
        btnChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatListActivity.class);
                intent.putExtra("userId", userId);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                intent.putExtra("userId", userId);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });


    }
}