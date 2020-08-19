package uz.peachdev.imtihongo.Manzillar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uz.peachdev.imtihongo.R;

public class AsosiyManzillar extends AppCompatActivity {

    CardView tosh, andijon, fargona, namangan, xorazm, buxoro, navoiy, jizzax, samarqand, qqalpoq, surxon, sirdaryo, qashqadaryo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asosiy_manzillar);
        tosh = findViewById(R.id.toshkent);
        tosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Toshkent.class);
                startActivity(intent);
            }
        });
        andijon = findViewById(R.id.andijon);
        andijon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Andijon.class);
                startActivity(intent);
            }
        });
        fargona = findViewById(R.id.fargona);
        fargona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Fargona.class);
                startActivity(intent);
            }
        });
        namangan = findViewById(R.id.namangan);
        namangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Namangan.class);
                startActivity(intent);
            }
        });
        xorazm = findViewById(R.id.xorazm);
        xorazm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Xorazm.class);
                startActivity(intent);
            }
        });
        buxoro = findViewById(R.id.buxoro);
        buxoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Buxoro.class);
                startActivity(intent);
            }
        });
        navoiy = findViewById(R.id.navoiy);
        navoiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Navoiy.class);
                startActivity(intent);
            }
        });
        jizzax = findViewById(R.id.jizzax);
        jizzax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Jizzax.class);
                startActivity(intent);
            }
        });
        samarqand = findViewById(R.id.samarqand);
        samarqand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Samarqand.class);
                startActivity(intent);
            }
        });
        qqalpoq = findViewById(R.id.qqalpoq);
        qqalpoq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Qqalpoq.class);
                startActivity(intent);
            }
        });
        surxon = findViewById(R.id.surxon);
        surxon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Surxondaryo.class);
                startActivity(intent);
            }
        });
        sirdaryo = findViewById(R.id.sirdar);
        sirdaryo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this, Sirdaryo.class);
                startActivity(intent);
            }
        });

        qashqadaryo = findViewById(R.id.qashqa);
        qashqadaryo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AsosiyManzillar.this,Qashqadaryo.class);
                startActivity(intent);
            }
        });


    }

}