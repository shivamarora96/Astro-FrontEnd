package com.saproductions.astro.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saproductions.astro.R;

/**
 * Created by shivam on 8/2/18.
 */

public class CustomAdapter extends ArrayAdapter<String> {

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

    private String [] title = {
      "ARIES", "TAURUS", "GEMINI", "CANCER", "LEO", "VIRGO", "LIBRA", "SCORPIO" , "SAGITTARIUS", "CAPRICORN", "AQUARIUS", "PISCES"
    };


    private Context context;

    public CustomAdapter(Context context) {
        super(context, 0);
        this.context = context;

    }


    @Override
    public int getCount() {
        return icons.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view ;

            if(position%2 == 0)
                view = inflater.inflate(R.layout.childonell, parent, false);
            else
                view = inflater.inflate(R.layout.childtwo, parent, false);

        TextView textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(title[position]);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageview);
        imageView.setImageResource(icons[position]);



        return view;
    }
}
