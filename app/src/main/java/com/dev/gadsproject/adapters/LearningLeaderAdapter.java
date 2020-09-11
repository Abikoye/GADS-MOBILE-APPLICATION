package com.dev.gadsproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.gadsproject.R;
import com.dev.gadsproject.databinding.ItemListLearningLeaderBinding;
import com.dev.gadsproject.model.HoursItem;

import java.util.ArrayList;
import java.util.List;


public class LearningLeaderAdapter extends RecyclerView.Adapter<LearningLeaderAdapter.ViewHolder> {

    private List<HoursItem> dataList;
    private Context context;

    public LearningLeaderAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
    }

    private void add(HoursItem item) {
        dataList.add(item);
        notifyItemInserted(dataList.size() - 1);
    }

    public void addAll(List<HoursItem> data) {
        for (HoursItem hourItem : data) {
            add(hourItem);
        }
    }

    public void remove(HoursItem item) {
        int position = dataList.indexOf(item);
        if (position > -1) {
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public HoursItem getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListLearningLeaderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_learning_leader, parent, false);

        final ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final HoursItem model = dataList.get(position);
        holder.bind(model,position);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemListLearningLeaderBinding binding;
        public ViewHolder(ItemListLearningLeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final HoursItem model,int position) {
            binding.txtName.setText(model.getName());
            binding.txtAddress.setText(model.getCountry());

        }


    }

    public interface ClickListner {
        void onItemClick(HoursItem model, int position);
    }

}
