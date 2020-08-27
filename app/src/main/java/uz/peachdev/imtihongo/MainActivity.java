package uz.peachdev.imtihongo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import uz.peachdev.imtihongo.DTMuchun.Abitur;
import uz.peachdev.imtihongo.DTMuchun.Qabul;
import uz.peachdev.imtihongo.Manzillar.AsosiyManzillar;
import uz.peachdev.imtihongo.Manzillar.Toshkent;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mDialog;
    ImageView iv,lang;
    CardView qabul, abitur, otm, reklama, manzillar;
    private String locate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocate();
        setContentView(R.layout.activity_main);

        lang = findViewById(R.id.lang);
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });



        otm = findViewById(R.id.otm);
        otm.setOnClickListener(view -> Toast.makeText(MainActivity.this, R.string.yaqinda_ishga, Toast.LENGTH_SHORT).show());

        qabul = findViewById(R.id.qabul);
        qabul.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Qabul.class);
            startActivity(intent);
        });
        abitur = findViewById(R.id.abitur);
        abitur.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Abitur.class);
            startActivity(intent);
        });
        reklama = findViewById(R.id.reklama);
        reklama.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Reklama.class);
            startActivity(intent);
        });

        iv = findViewById(R.id.infoim);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mDialog = new ProgressDialog(MainActivity.this);
                //Show dialog

                mDialog.show();
                //Set Content View

                mDialog.setContentView(R.layout.info_dialog);
                //Set transparent Background
                mDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );

            }
        });
        manzillar = findViewById(R.id.manzillar);
        manzillar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AsosiyManzillar.class);
                startActivity(intent);
            }
        });


    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"O'zbekcha", "Русский"};

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Tilni tanlang . . .");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocate("uz");
                    recreate();

                } else if (i == 1) {
                    setLocate("ru");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    public void setLocate(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocate(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_lang","");
        setLocate(language);
    }
}