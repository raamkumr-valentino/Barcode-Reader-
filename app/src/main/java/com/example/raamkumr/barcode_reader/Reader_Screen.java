package com.example.raamkumr.barcode_reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class Reader_Screen extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader__screen);
        txt=(TextView)findViewById(R.id.txtcontent);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanBarcode(v);
            }
        });

    }

    public void scanBarcode(View v)
    {
        Intent intent=new Intent(this,sacnScreen.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            if(resultCode== CommonStatusCodes.SUCCESS)
            {
                if(data!=null)
                {
                    Barcode barcode=data.getParcelableExtra("barcode");
                    txt.setText("Barcode Value :" + barcode.displayValue);
                }else {
                    txt.setText("No Barcode Found");
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
