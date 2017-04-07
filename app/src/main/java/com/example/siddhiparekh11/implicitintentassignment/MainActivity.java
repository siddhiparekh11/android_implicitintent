package com.example.siddhiparekh11.implicitintentassignment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLaunch(View v)
    {
        EditText text1= (EditText) findViewById(R.id.editText1);
        String url= text1.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent openUrl=new Intent(Intent.ACTION_VIEW,webpage);
        Intent chooser = Intent.createChooser(openUrl, "Open this URL via...");
        if(openUrl.resolveActivity(getPackageManager())!=null){
            startActivity(chooser);
        }

    }
    public void onRing(View v)
    {
        EditText text2= (EditText) findViewById(R.id.editText2);
        String digits= text2.getText().toString();
        Uri number=Uri.parse("tel:"+digits);
        Intent callNumber=new Intent(Intent.ACTION_DIAL,number);
        Intent chooser = Intent.createChooser(callNumber, "Call this Number via...");
        if(callNumber.resolveActivity(getPackageManager())!=null){
            startActivity(chooser);
        }

    }
    public void finishMainActivity(View v)
    {
        this.finish();
    }
}
