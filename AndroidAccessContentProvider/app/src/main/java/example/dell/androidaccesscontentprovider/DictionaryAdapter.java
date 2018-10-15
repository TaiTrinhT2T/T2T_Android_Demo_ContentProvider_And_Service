package example.dell.androidaccesscontentprovider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryViewHolder> {
    private Context context;
    private List<ModelWords> wordList;

    public DictionaryAdapter(Context context, List<ModelWords> wordList){
        this.context = context;
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public DictionaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_layout, parent, false);
        return new DictionaryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryViewHolder holder, int position) {
        ModelWords row = wordList.get(position);
        holder.word.setText(row.getWord());
        holder.mean.setText(row.getMean());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }
}
