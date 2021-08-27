package RecyclerViews;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

import RecyclerViews.Poster;

public class PosterViewHolder extends RecyclerView.ViewHolder {
    private ImageView PosterImage;
    public PosterViewHolder(@NonNull View itemView) {
        super(itemView);
        PosterImage = itemView.findViewById(R.id.PosterImage);
    }
    public void setData(Poster poster){
        PosterImage.setImageResource(poster.getPorterImage());
    }
}
