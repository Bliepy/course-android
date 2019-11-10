package efile.com.efiles.repository;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import efile.com.efiles.model.EvidenceModel;


public class EvidenceViewModel extends ViewModel {

    public List<EvidenceModel> list = new ArrayList<>();

    public EvidenceViewModel(Context context) {
        loadStubData();
    }

    public List<EvidenceModel> getList() {
        return list;
    }

    public EvidenceModel get(int index) {
        return list.get(index);
    }

    public void edit(int index, EvidenceModel model) {
        list.set(index, model);
    }

    public void add(EvidenceModel model) {
        list.add(model);
    }

    public void remove(EvidenceModel model) {
        list.remove(model);
    }

    public void loadStubData() {
        EvidenceModel model1 = new EvidenceModel();
        model1.setId(1);
        model1.setCreateDate("11/11/11");
        model1.setDescription("test tester test");
        model1.setOwner("piet");
        list.add(model1);

        EvidenceModel model2 = new EvidenceModel();
        model2.setId(1);
        model2.setCreateDate("11/11/11");
        model2.setDescription("test tester test");
        model2.setOwner("piet");
        list.add(model2);

        EvidenceModel model = new EvidenceModel();
        model.setId(1);
        model.setCreateDate("11/11/11");
        model.setDescription("test tester test");
        model.setOwner("jaap");
        list.add(model);

        EvidenceModel model3 = new EvidenceModel();
        model3.setId(1);
        model3.setCreateDate("11/11/11");
        model3.setDescription("test tester test");
        model3.setOwner("jan");
        list.add(model);

    }
}
