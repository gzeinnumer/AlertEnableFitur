package com.gzeinnumer.enablefitur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gzeinnumer.mylibdialog.dialog.infoDialog.InfoDialog;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: "+askToActive());
            }
        });
    }

    private boolean askToActive() {
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            new InfoDialog(getSupportFragmentManager())
                    .setTitle("Warning")
                    .setContent("GPS harus aktive")
                    .onOkPressedCallBack(new InfoDialog.OnOkPressed() {
                        @Override
                        public void onOkPressed() {
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).show();
            return false;
        } else {
            return true;
        }
    }
}