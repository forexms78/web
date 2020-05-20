package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button go, ba, fo;
    WebView wv;
    View.OnClickListener cl;
    MyClient mc;

    class MyClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        url = (EditText) findViewById(R.id.text);
        go = (Button) findViewById(R.id.go);
        ba = (Button) findViewById(R.id.back);
        fo = (Button) findViewById(R.id.forward);
        wv = (WebView) findViewById(R.id.web);

        mc = new MyClient();
        wv.setWebViewClient(mc);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.go:
                        wv.loadUrl(url.getText().toString());
                        break;
                    case R.id.back:
                        wv.goBack();
                        break;
                    case R.id.forward:
                        wv.goForward();
                        break;
                }
            }
        };
        go.setOnClickListener(cl);
        ba.setOnClickListener(cl);
        fo.setOnClickListener(cl);
    }
}
