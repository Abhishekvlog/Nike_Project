package RecyclerViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

import java.util.ArrayList;

public class Shoe3Adapter extends RecyclerView.Adapter<Shoe3ViewHolder> {
    private ArrayList<Shoe3> shoe3List= new ArrayList<>();
    private ItemClickListener itemClickListener;
    public Shoe3Adapter (ArrayList<Shoe3> shoe3List, ItemClickListener itemClickListener){
        this.shoe3List = shoe3List;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public Shoe3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout3,parent,false);
        return new Shoe3ViewHolder(view,itemClickListener);    }

    @Override
    public void onBindViewHolder(@NonNull Shoe3ViewHolder holder, int position) {
        Shoe3 shoe3 = shoe3List.get(position);
        holder.setData3(shoe3);
    }

    @Override
    public int getItemCount() {
        return shoe3List.size();
    }
}
