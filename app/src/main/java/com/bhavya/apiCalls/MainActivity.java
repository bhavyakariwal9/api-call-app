package com.bhavya.apiCalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    final static String URL="https://backend-test-zypher.herokuapp.com/testData";

    /*TextView tvtitle;
    ImageView ivImageUrl;
    Button btnSuccess;
    ShowDialogBox showDialogBox;
    */

    SwipeDismissDialog swipeDismissDialog;
    TextView tvTitle2;
    ImageView ivimg2;
    Button btnSuccess2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tvtitle=findViewById(R.id.tvTitle);
        //ivImageUrl=findViewById(R.id.ivImageUrl);
        //btnSuccess=findViewById(R.id.btnSuccess);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest=new JsonObjectRequest(
                Request.Method.POST,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response",response.toString());
                        try {
                            String title=response.getString("title");
                            String imgUrl=response.getString("imageURL");
                            String success=response.getString("success_url");

                            /*
                            //showDialogBox=new ShowDialogBox(getApplicationContext(),title,imgUrl,success);
                            //FragmentTransaction fragmentManager=getSupportFragmentManager().beginTransaction();

                            tvtitle.setText(title);
                            Glide.with(getApplicationContext()).load(imgUrl).into(ivImageUrl);
                            btnSuccess.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(success));
                                    startActivity(intent);
                                }
                            });

                            */

                            View dialog= LayoutInflater.from(getBaseContext()).inflate(R.layout.swipable_dialog,null);
                            swipeDismissDialog=new SwipeDismissDialog.Builder(MainActivity.this)
                                    .setView(dialog).build().show();

                            tvTitle2=dialog.findViewById(R.id.tvTitle2);
                            tvTitle2.setText(title);

                            ivimg2=dialog.findViewById(R.id.ivImageUrl2);
                            Glide.with(getApplicationContext()).load(imgUrl).into(ivimg2);

                            btnSuccess2=dialog.findViewById(R.id.btnSuccess2);

                            btnSuccess2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(success));
                                    startActivity(intent);
                                }
                            });



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error res",error.toString());
                    }
                }

        );
        requestQueue.add(objectRequest);
    }
}