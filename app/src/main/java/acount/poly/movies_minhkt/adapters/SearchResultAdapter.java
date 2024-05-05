package acount.poly.movies_minhkt.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import acount.poly.movies_minhkt.R;
import acount.poly.movies_minhkt.models.Movie;
import acount.poly.movies_minhkt.ui.activities.DetailActivity;
import acount.poly.movies_minhkt.utils.Constants;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    List<Movie> mResults;
    Context mContext;

    public SearchResultAdapter(List<Movie> results) {
        mResults = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.view_search_result, parent, false
            )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie result = mResults.get(position);
        holder.name.setText(result.title);
        holder.container.setOnClickListener((v) -> {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(Constants.MOVIE_ID, result.id);
            intent.putExtra(Constants.VOTE_AVERAGE, result.vote_average);
            intent.putExtra(Constants.OVERVIEW, result.overview);
            intent.putExtra(Constants.TITLE, result.title);
            intent.putExtra(Constants.BACKDROP_IMAGE_PATH, result.backdrop_path);
            intent.putExtra(Constants.POSTER_PATH, result.poster_path);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }

        TextView name = itemView.findViewById(R.id.tvName);
        View container = itemView.findViewById(R.id.container);
    }
}
