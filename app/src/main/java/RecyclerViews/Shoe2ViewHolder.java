package RecyclerViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

public class Shoe2ViewHolder extends RecyclerView.ViewHolder {
    private ImageView mTvCard2Image;
    private TextView mTvCard2Text;
    private ItemClickListener itemClickListener;
    public Shoe2ViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvCard2Image = itemView.findViewById(R.id.card2Viewimage);
        mTvCard2Text = itemView.findViewById(R.id.card2textview);
    }
    public void setData2(Shoe2 shoe2){
        mTvCard2Image.setImageResource(shoe2.getmTvCard2Image());
        mTvCard2Text.setText(shoe2.getmTvCard2TextView());
    }
}
