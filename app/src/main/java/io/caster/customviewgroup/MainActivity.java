package io.caster.customviewgroup;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.caster.example.ListItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ListItemAdapter(this, ListItem.values()));
    }

    // RecyclerView classes

    /**
     * {@link RecyclerView.ViewHolder} subclass that holds references to
     * views for each layout example.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        // Views
        ImageView iconView;
        TextView titleView;
        TextView subtitleView;

        /**
         * Constructor
         *
         * @param itemView View for the item.
         */
        ViewHolder(View itemView) {
            super(itemView);

            iconView = itemView.findViewById(R.id.icon);
            titleView = itemView.findViewById(R.id.title);
            subtitleView = itemView.findViewById(R.id.subtitle);
        }
    }

    static class ListItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final LayoutInflater inflater;
        private final ListItem[] items;

        /**
         * Constructor.
         *
         * @param context The current context.
         */
        ListItemAdapter(Context context, ListItem[] items) {
            this.inflater = LayoutInflater.from(context);
            this.items = items;
        }

        //
        // RecyclerView.Adapter<ViewHolder> implementation
        //

        @Override
        public int getItemCount() {
            return ListItem.values().length;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(inflater.inflate(R.layout.list_item_custom, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final ListItem item = items[position];
            holder.iconView.setImageResource(item.iconResId);
            holder.titleView.setText(item.titleResId);
            holder.subtitleView.setText(item.descResId);
        }
    }
}
