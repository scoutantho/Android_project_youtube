package com.example.antho.android_youtube_project;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnCellsSelectedListener {

private static final String API_Key = "AIzaSyAhgLS1kREdepYS9_X-RwlkrXZKst-Dgpk";
    private static final String Begin_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=";
    private RecyclerView recyclerView;

   // private static final String "?part=snippet&maxResult=25<"+API_Key+">";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button mButton = (Button)findViewById(R.id.search_button);
        final EditText mEditText = (EditText)findViewById(R.id.SearchEditText);


        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               String research = mEditText.getText().toString();
                getVideos(Begin_URL+research+"&key="+API_Key+"");
            }
        });
    }

    private void getVideos(String research){
        StringRequest videosRequest = new StringRequest(research, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Example cells = new Gson().fromJson(response,Example.class); //??
                setAdapter( cells.getItems());

                }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(List<Cell> cells){
        CellsAdapter adapter = new CellsAdapter(cells);
        adapter.setOnCellsSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCellSelected(Cell cell){
        VideoActivity.start(this, cell.getSnippet().getTitle());
    }

}
