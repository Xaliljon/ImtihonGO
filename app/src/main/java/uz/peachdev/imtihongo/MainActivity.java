package uz.peachdev.imtihongo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uz.peachdev.imtihongo.DTMuchun.Abitur;
import uz.peachdev.imtihongo.DTMuchun.Qabul;
import uz.peachdev.imtihongo.Manzillar.AsosiyManzillar;
import uz.peachdev.imtihongo.Manzillar.Toshkent;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mDialog;
    ImageView iv;
    CardView qabul, abitur, otm, reklama, manzillar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        otm = findViewById(R.id.otm);
        otm.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Yaqinda ishga tushiriladi.", Toast.LENGTH_SHORT).show());

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

}