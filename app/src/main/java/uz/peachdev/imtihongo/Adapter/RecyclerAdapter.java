package uz.peachdev.imtihongo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uz.peachdev.imtihongo.Model.Model;
import uz.peachdev.imtihongo.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String Tag = "RecyclerView";

    private Context mContext;
    private ArrayList<Model> modelsList;


    public RecyclerAdapter(Context mContext, ArrayList<Model> modelsList) {
        this.mContext = mContext;
        this.modelsList = modelsList;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reklama, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        //TextView
        holder.textView.setText(modelsList.get(position).getName());
        holder.post_desc.setText(modelsList.get(position).getDesc());
        holder.post_time.setText(modelsList.get(position).getTime());

        //ImageView : Glide library
        Glide.with(mContext)
                .load(modelsList.get(position).getImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Widgets;
        ImageView imageView;
        TextView textView,post_desc,post_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.post_title);
            post_desc = itemView.findViewById(R.id.post_desc);
            post_time = itemView.findViewById(R.id.post_time);

        }
    }

}
