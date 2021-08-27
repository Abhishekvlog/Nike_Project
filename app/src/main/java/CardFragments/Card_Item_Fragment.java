package CardFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.HomePage;
import RecyclerViews.ItemClickListener;
import RecyclerViews.ItemDetail;
import com.example.nike.R;
import RecyclerViews.Shoe1;

import java.util.ArrayList;

public class Card_Item_Fragment extends Fragment implements ItemClickListener {

    private RecyclerView recyclerView;
    public static ArrayList<ItemDetail> itemDetail = new ArrayList<>();
    private Button CardToShopping;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_item,container,false);
        CardToShopping = container.findViewById(R.id.carttoshoping);
        recyclerView= container.findViewById(R.id.cartRecyclerView);

        if (itemDetail.size() == 0){
            CardToShopping.setVisibility(View.VISIBLE);
            CardToShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getContext(), HomePage.class);
                    startActivity(intent);
                }
            });
        }
        else {
            //setRecyclerView();
        }
        return view;
    }

//    private void setRecyclerView() {
//        ShoeAdapter shoeAdapter = new ShoeAdapter( itemDetail, this);
//        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(shoeAdapter);
//    }


    @Override
    public void onItemClicked(int position, Shoe1 shoe1) {

    }
}
