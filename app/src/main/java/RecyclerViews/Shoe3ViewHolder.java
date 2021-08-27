package RecyclerViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

public class Shoe3ViewHolder extends RecyclerView.ViewHolder {
    private ImageView mTvCard3Image;
    private TextView mTvCard3Text;
    private ItemClickListener itemClickListener;
    public Shoe3ViewHolder(@NonNull View itemView , ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initView(itemView);

    }

    private void initView(View itemView) {
        mTvCard3Image = itemView.findViewById(R.id.card3Viewimage);
        mTvCard3Text = itemView.findViewById(R.id.card3textview);
    }
    public void setData3(Shoe3 shoe3){
        mTvCard3Image.setImageResource(shoe3.getmTvCard3Image());
        mTvCard3Text.setText(shoe3.getmTvCard3Name());
    }
}
