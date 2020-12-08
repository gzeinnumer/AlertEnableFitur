# AlertEnableFitur
 GPS Must Be Active

- Enable dialog that i use [MyLibDialog](https://github.com/gzeinnumer/MyLibDialog)

```java
public class MainActivity extends AppCompatActivity {

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: "+askToActive()); // true if active, false if not active
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
```

---

```
Copyright 2020 M. Fadli Zein
```