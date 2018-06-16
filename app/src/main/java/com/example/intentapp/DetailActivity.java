package com.example.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intentapp.entity.Article;

public class DetailActivity extends AppCompatActivity {
    private TextView tvView;
    private EditText etMessage;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvView=findViewById(R.id.viewDetial);
        etMessage=findViewById(R.id.dtMessage);
        btnBack=findViewById(R.id.btnsendBack);
        if(getIntent()!=null){
            Intent intent=getIntent();
          /*
            String title=intent.getStringExtra("title");
            String desc=intent.getStringExtra("desc");*/
            Article article=intent.getParcelableExtra("data");

            //tvView.setText("Title :"+title + " desc "+desc);
            tvView.setText("Title :"+article.getTitle() + " desc "+article.getDesc());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.putExtra("message",etMessage.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
