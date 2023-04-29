package com.example.chat01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        //로그인 세션 유지
        Intent intent = getIntent();
        final String userId = intent.getExtras().getString("userId");
        TextView testId =(TextView) findViewById(R.id.testId);
        testId.setText(userId);


        LinearLayout LLFriend = (LinearLayout) findViewById(R.id.LLFriend);

        Button btnHome =(Button) findViewById(R.id.btnHome);
        Button btnChatList =(Button) findViewById(R.id.btnChatList);
        Button btnSetting =(Button) findViewById(R.id.btnSetting);


        LLFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("userId", userId);
                ChatListActivity.this.startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("userId", userId);
                ChatListActivity.this.startActivity(intent);
                finish();
            }
        });
        btnChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatListActivity.class);
                intent.putExtra("userId", userId);
                ChatListActivity.this.startActivity(intent);
                finish();
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                intent.putExtra("userId", userId);
                ChatListActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}