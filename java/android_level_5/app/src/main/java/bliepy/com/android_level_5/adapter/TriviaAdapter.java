package bliepy.com.android_level_5.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bliepy.com.android_level_5.R;
import bliepy.com.android_level_5.model.TriviaModel;

public class TriviaAdapter extends RecyclerView.Adapter<TriviaAdapter.TriviaViewHolder> {

    public List<TriviaModel> listTrivia;

    public TriviaAdapter(List<TriviaModel> listTrivia ) {
        this.listTrivia = listTrivia;
    }

    @NonNull
    @Override
    public TriviaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from( viewGroup.getContext());
        View view =  inflater.inflate(R.layout.item_trivia, viewGroup, false);
        return new TriviaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaViewHolder triviaViewHolder, int i) {
        TriviaModel model =  listTrivia.get(i);
        triviaViewHolder.triviaNumber.setText(""+model.getNumber());
        triviaViewHolder.triviaMessage.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return listTrivia.size();
    }

    public class TriviaViewHolder extends RecyclerView.ViewHolder {
        public TextView triviaNumber, triviaMessage;

        public TriviaViewHolder(@NonNull View view) {
            super(view);
            triviaNumber = view.findViewById(R.id.trivia_text);
            triviaMessage = view.findViewById(R.id.trivia_message);
        }
    }
}
