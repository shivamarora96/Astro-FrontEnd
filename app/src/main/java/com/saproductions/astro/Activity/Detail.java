package com.saproductions.astro.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.saproductions.astro.Helper.Rashi;
import com.saproductions.astro.R;

public class Detail extends AppCompatActivity {

    ImageView imageView;
    TextView textView, date_tv;
    Button share;

    private Integer [] icons = {
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,
            R.drawable.i10,
            R.drawable.i11,
            R.drawable.i12,

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView)findViewById(R.id.rashiimageview);
        textView = (TextView)findViewById(R.id.rashitextview);
        date_tv = (TextView)findViewById(R.id.rashidate);

        share = (Button)findViewById(R.id.rashishare);

        /*
         i.putExtra("position", position);
                i.putExtra("status", data.getStatus() );
                i.putExtra("date", data.getDate());
                i.putExtra("title", data.getData().get(position).getTitle());
                i.putExtra("content", data.getData().get(position).getContent());

        */
        Intent i = getIntent();

         boolean status = i.getBooleanExtra("status", false);

        int position = i.getIntExtra("position" , 0);
        imageView.setImageResource(icons[position]);

        if(status) {
            final Rashi rashi = new Rashi();
            rashi.setContent(i.getStringExtra("content"));
            rashi.setDate(i.getStringExtra("date"));
            rashi.setTitle(i.getStringExtra("title"));
            date_tv.setText(rashi.getDate());
            textView.setText(rashi.getContent());


            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, rashi.getDate().concat(rashi.getContent()));
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
            });

        }
    }
}
