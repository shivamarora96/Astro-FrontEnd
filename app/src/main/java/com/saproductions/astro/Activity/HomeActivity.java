package com.saproductions.astro.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.saproductions.astro.Adapter.CustomAdapter;
import com.saproductions.astro.Helper.ApiClient;
import com.saproductions.astro.Helper.ApiInterface;
import com.saproductions.astro.Helper.Rashi;
import com.saproductions.astro.Helper.Response;
import com.saproductions.astro.R;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity {


   ListView listView;
   CustomAdapter adapter;

   Response data = new Response();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        adapter = new CustomAdapter(HomeActivity.this);
        listView.setAdapter(adapter);


        final ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Fetching Data");
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);
        progressDialog.setIcon(R.drawable.icon);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.show();



        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> call = apiInterface.getAll();

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                data = response.body();
                Toast.makeText(HomeActivity.this, "Success" , Toast.LENGTH_LONG).show();
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "KINDLY CHECK YOUR INTERNET CONNECTION" , Toast.LENGTH_LONG).show();
                progressDialog.hide();

            }
        });





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(HomeActivity.this, Detail.class);
                i.putExtra("position", position);
                i.putExtra("status", data.getStatus() );
                i.putExtra("date", data.getDate());
                i.putExtra("title", data.getData().get(position).getTitle());
                i.putExtra("content", data.getData().get(position).getContent());
                startActivity(i);


            }
        });




    }
}
