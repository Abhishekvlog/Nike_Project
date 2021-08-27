package RecyclerViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

import java.util.ArrayList;

public class Shoe2Adapter extends RecyclerView.Adapter<Shoe2ViewHolder> {
    private ArrayList<Shoe2>shoe2List= new ArrayList<>();
    private ItemClickListener itemClickListener;
    public Shoe2Adapter (ArrayList<Shoe2> shoe2List , ItemClickListener itemClickListener){
        this.shoe2List = shoe2List;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public Shoe2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2,parent,false);
        return new Shoe2ViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Shoe2ViewHolder holder, int position) {
        Shoe2 shoe2 = shoe2List.get(position);
        holder.setData2(shoe2);
    }

    @Override
    public int getItemCount() {
        return shoe2List.size();
    }
}
