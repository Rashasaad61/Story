package com.example.toshiba.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

public class webhtml extends AppCompatActivity {
    PDFView book ;
    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webhtml);
        book= (PDFView)  findViewById(R.id.pdf);

        Intent data = getIntent();
        int page=data.getExtras().getInt("page");
        page++;
        book.fromAsset(page+".pdf").load();

    }

}
