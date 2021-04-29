package com.bhavya.apiCalls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

public class ShowDialogBox extends Activity {
    String title;
    String img_url;
    String success_url;
    Context context;

    //SwipeDismissDialog swipeDismissDialog;

    public ShowDialogBox(){}

    public ShowDialogBox(Context context, String title, String img_url, String success_url){
        this.context=context;
        this.title=title;
        this.img_url=img_url;
        this.success_url=success_url;
    }

   /* TextView tvTitle2;
    ImageView ivimg2;
    Button btnSuccess2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View dialog=LayoutInflater.from(context).inflate(R.layout.swipable_dialog,null);
        swipeDismissDialog=new SwipeDismissDialog.Builder(context).setView(dialog).build().show();

        tvTitle2=dialog.findViewById(R.id.tvTitle2);
        tvTitle2.setText(title);

        ivimg2=dialog.findViewById(R.id.ivImageUrl2);
        Glide.with(getApplicationContext()).load(img_url).into(ivimg2);

        btnSuccess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(success_url));
                startActivity(intent);
            }
        });

    }*/
}
