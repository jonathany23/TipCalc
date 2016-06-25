package edu.galileo.android.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.tipcalc.R;
import edu.galileo.android.tipcalc.models.TipRecord;

/**
 * Created by jonathan on 6/24/2016.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {
    private Context context;
    private List<TipRecord> dataset;
    private OnItemClicListener onItemClicListener;

    public TipAdapter(Context context, List<TipRecord> dataset, OnItemClicListener onItemClicListener) {
        this.context = context;
        this.dataset = dataset;
        this.onItemClicListener = onItemClicListener;
    }

    public TipAdapter(Context context, OnItemClicListener onItemClicListener) {
        this.context = context;
        this.dataset = new ArrayList<TipRecord>();
        this.onItemClicListener = onItemClicListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element = dataset.get(position);
        String strTip = String.format(context.getString(R.string.global_message_tip), element.getTip());
        holder.txtContent.setText(strTip);
        holder.setOnItemClickListener(element, onItemClicListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add (TipRecord record){
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void clear (){
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txtContent)
        TextView txtContent;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setOnItemClickListener(final TipRecord element, final OnItemClicListener onItemClicListener) {
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onItemClicListener.onItemClick(element);
                }
            });
        }
    }
}
