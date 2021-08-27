package RecyclerViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

import java.util.ArrayList;

public class PosterAdapter extends RecyclerView.Adapter<PosterViewHolder> {
    private ArrayList<Poster> posterList = new ArrayList<>();
    public PosterAdapter(ArrayList<Poster> posterList){
        this.posterList = posterList;
    }
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_layout,parent,false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        Poster poster = posterList.get(position);
        holder.setData(poster);
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }
}
