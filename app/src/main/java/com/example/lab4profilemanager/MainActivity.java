package com.example.lab4profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText)findViewById(R.id.teamAddressField);

        // create a Uri from an intent string
        // use the result to create an Intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        // create an Intent from gmmIntentUri
        // set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // make the intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        // application context and activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) return;

        // getting the avatar image we show to users
        ImageView avatarImage = (ImageView)findViewById(R.id.logoImage);

        // figure out the correct image
        String drawableName = "ic_logo_00";

        int asd = data.getIntExtra("imageID", R.id.logoImage00);

        if (asd == R.id.logoImage00) {
            drawableName = "ic_logo_00";
        }
        else if (asd == R.id.logoImage01) {
            drawableName = "ic_logo_01";
        }
        else if (asd == R.id.logoImage02) {
            drawableName = "ic_logo_02";
        }
        else if (asd == R.id.logoImage03) {
            drawableName = "ic_logo_03";
        }
        else if (asd == R.id.logoImage04) {
            drawableName = "ic_logo_04";
        }
        else if (asd == R.id.logoImage05) {
            drawableName = "ic_logo_05";
        }
        else {
            throw new IllegalStateException("Unexpected value: " + data.getIntExtra("imageID", R.id.logoImage00));
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        avatarImage.setImageResource(resID);
    }
}