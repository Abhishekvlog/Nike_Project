package RecyclerViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

import java.util.ArrayList;

public class ShoeAdapter extends RecyclerView.Adapter<ShoeViewHolder> {
    private ArrayList<Shoe1> shoe1List = new ArrayList<>();
    private ItemClickListener itemClickListener;
    public ShoeAdapter(ArrayList<Shoe1> shoe1List, ItemClickListener itemClickListener){
        this.shoe1List = shoe1List;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public ShoeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout1,parent,false);
        return new ShoeViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoeViewHolder holder, int position) {
        Shoe1 shoe1 = shoe1List.get(position);
        holder.setData(shoe1);

    }

    @Override
    public int getItemCount() {
        return shoe1List.size();
    }
}
