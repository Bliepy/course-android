package efile.com.efiles.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import efile.com.efiles.R;
import efile.com.efiles.model.EvidenceModel;
import efile.com.efiles.repository.EvidenceViewModel;

public class EvidenceFragment extends Fragment {

    public EvidenceViewModel viewModel;
    public List<EvidenceModel> evidenceList;
    public RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView  = inflater.inflate(R.layout.fragment_evidence, container, false);

        viewModel = new EvidenceViewModel(getContext());
        evidenceList = viewModel.getList();

        final EvidenceAdapter adapter = new EvidenceAdapter(evidenceList);
        recyclerView = fragmentView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        return fragmentView;
    }

    class EvidenceAdapter extends RecyclerView.Adapter<EvidenceAdapter.ViewHolder> {

        public List<EvidenceModel> list;
        public EvidenceAdapter(List<EvidenceModel> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public EvidenceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View view = inflater.inflate(R.layout.item_evidence, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EvidenceAdapter.ViewHolder viewHolder, int i) {
            EvidenceModel model = list.get(i);
            viewHolder.identifier.setText(""+model.getId());
            viewHolder.description.setText(model.getDescription());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView owner, description, identifier;

            public ViewHolder(@NonNull View view) {
                super(view);
                owner = view.findViewById(R.id.owner);
                description = view.findViewById(R.id.description);
                identifier = view.findViewById(R.id.identifier);
            }
        }
    }
}
