package uz.peachdev.imtihongo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import uz.peachdev.imtihongo.Adapter.RecyclerAdapter;
import uz.peachdev.imtihongo.Model.Model;

public class Reklama extends AppCompatActivity {

    private RecyclerView myRecycler;


    //Firebase
    private DatabaseReference myRef;

    // Variables:
    private ArrayList<Model> modelsList;

    private RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reklama);


        myRecycler =findViewById(R.id.myrecyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setHasFixedSize(true);

        //Firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //ArrayList:
        modelsList = new ArrayList<>();

        //Clear ArrayList
        ClearAll();

        //Get Data Method

        GetDataFromFirebase();

    }

    private void GetDataFromFirebase() {

        Query query = myRef.child("Post");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    Model model = new Model();

                    model.setImageUrl(snapshot1.child("image").getValue().toString());
                    model.setName(snapshot1.child("name").getValue().toString());
                    model.setDesc(snapshot1.child("desc").getValue().toString());
                    model.setTime(snapshot1.child("time").getValue().toString());
                    modelsList.add(model);
                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), modelsList);
                myRecycler.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void ClearAll(){
        if (modelsList != null){
            modelsList.clear();

            if (recyclerAdapter!= null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        modelsList = new ArrayList<>();
    }
}