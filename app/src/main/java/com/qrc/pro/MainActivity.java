package com.qrc.pro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

WebView w;

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);

w = new WebView(this);

WebSettings s = w.getSettings();
s.setJavaScriptEnabled(true);
s.setDomStorageEnabled(true);
s.setLoadsImagesAutomatically(true);
s.setCacheMode(WebSettings.LOAD_DEFAULT);

w.setLayerType(WebView.LAYER_TYPE_HARDWARE,null);

w.addJavascriptInterface(new Object(){

@android.webkit.JavascriptInterface
public void scanQR(){
w.loadUrl("javascript:onScanResult('Scanner Ready')");
}

},"Android");

w.loadUrl("file:///android_asset/www/splash.html");

setContentView(w);
}
}