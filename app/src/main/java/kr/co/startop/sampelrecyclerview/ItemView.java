package kr.co.startop.sampelrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jihun on 02/11/2018.
 */

public class ItemView extends RecyclerView.ViewHolder {
    private OnItemClickListener itemClickListener;

    public void setOnClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    ImageView profileView;
    TextView ageView, nameView;

    public ItemView(final View itemView) {
        super(itemView);
        profileView = itemView.findViewById(R.id.image_profile);
        ageView = itemView.findViewById(R.id.text_age);
        nameView = itemView.findViewById(R.id.text_name);

        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (person != null) {
//                    Toast.makeText(itemView.getContext(), person.name, Toast.LENGTH_SHORT).show();
                    if (itemClickListener != null) {
                        itemClickListener.OnItemClick(person, getAdapterPosition());
                    }
                }
            }
        });
    }

    Person person = null;
    public void setData(Person person) {
        this.person = person;
        ageView.setText("" + person.age);
        nameView.setText(person.name);
    }
}
