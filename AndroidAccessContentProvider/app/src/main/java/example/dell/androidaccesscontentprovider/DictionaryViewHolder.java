package example.dell.androidaccesscontentprovider;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DictionaryViewHolder extends RecyclerView.ViewHolder {
    public TextView word;
    public TextView mean;
    public DictionaryViewHolder(View itemView) {
        super(itemView);
        word = (TextView) itemView.findViewById(R.id.word);
        mean = (TextView) itemView.findViewById(R.id.mean);
    }
}
