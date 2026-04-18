package com.qrc.pro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MainActivity extends Activity {

WebView w;

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);

w = new WebView(this);

WebSettings s = w.getSettings();
s.setJavaScriptEnabled(true);
s.setDomStorageEnabled(true);

w.addJavascriptInterface(new Object(){

@android.webkit.JavascriptInterface
public void scanQR(){
w.loadUrl("javascript:onScanResult('Scanner coming soon')");
}

},"Android");

w.loadUrl("file:///android_asset/www/splash.html");

setContentView(w);
}
}