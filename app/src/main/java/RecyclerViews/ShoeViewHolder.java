package RecyclerViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.R;

public class ShoeViewHolder extends RecyclerView.ViewHolder {
    private ImageView mTvimage;
    private TextView mTvname;
    private ItemClickListener itemClickListener;
    private RelativeLayout relativeLayout1;
    public ShoeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener =itemClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvimage = itemView.findViewById(R.id.cardViewimage);
        mTvname=itemView.findViewById(R.id.card1textView);
        relativeLayout1 =itemView.findViewById(R.id.relativelayout1);

    }
    public void setData(Shoe1 shoe1){
        mTvname.setText(shoe1.getmTvName());
        mTvimage.setImageResource(shoe1.getmTvImage());
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked(getAdapterPosition(),shoe1);
            }
        });
    }
}
