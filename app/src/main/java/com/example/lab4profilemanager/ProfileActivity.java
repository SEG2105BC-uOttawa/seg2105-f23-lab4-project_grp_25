package com.example.lab4profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void SetTeamIcon(View view) {
        // create a return intent to pass to the Main Activity
        Intent returnIntent = new Intent();

        // figure out which image was clicked
        ImageView selectedImage = (ImageView)view;

        // add stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());

        setResult(RESULT_OK, returnIntent);

        // finish activity and return to main screen
        finish();
    }
}