package com.example.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intentapp.entity.Article;

public class HomeActivity extends AppCompatActivity {

    private EditText tvTitle,tvDesc;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTitle=findViewById(R.id.tvTitle);
        tvDesc=findViewById(R.id.tvDesc);
        btnSend=findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,DetailActivity.class);

                /*intent.putExtra("title",tvTitle.getText().toString());
                intent.putExtra("desc",tvDesc.getText().toString());*/

            // send as object
                Article article=new Article();
                article.setTitle(tvTitle.getText().toString());
                article.setDesc(tvDesc.getText().toString());
                Bundle bundle=new Bundle();
                bundle.putParcelable("data",article);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            String sms=data.getStringExtra("message");
            Log.e("activity",sms);
        }

    }
}
