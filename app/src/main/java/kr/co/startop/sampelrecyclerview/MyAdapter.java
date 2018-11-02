package kr.co.startop.sampelrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jihun on 02/11/2018.
 */

public class MyAdapter extends RecyclerView.Adapter implements OnItemClickListener {
    List<Person> items = new ArrayList<>();

    public void add(Person person) {
        items.add(person);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_item, parent, false);

        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemView) holder).setData(items.get(position));
        ((ItemView) holder).setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private OnItemClickListener itemClickListener;

    public void setOnClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }


    @Override
    public void OnItemClick(Person person, int position) {
        if (itemClickListener != null) {
            itemClickListener.OnItemClick(person, position);
        }
    }
}
