package com.example.toshiba.story;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        String[] item = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.textView2, item);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,webhtml.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        });
    }


    public void email(View view) {
        String txt = "السلام عليكم ورحمه الله وبركاته/nاقتراحى هو:";
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("milto"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL,"engrashasaad61@gmail.com");
        email.putExtra(Intent.EXTRA_SUBJECT,"تطبيق قصص الأنبياء");
    email.putExtra(Intent.EXTRA_TEXT,txt);
    startActivity(email);}

    public void share(View view) {
        String txt = "تطبيق قصص الأنبياء";
        String link = "";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txt+"/n" +link);
    }

    public void cancel(View view) {
        finish();
    }

    public void star(View view) {
    }
}
