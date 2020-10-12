package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ListFragment extends Fragment {


    private TransactionViewModel model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        model = new ViewModelProvider((MainActivity) requireActivity()).get(TransactionViewModel.class);

        ListView lv = view.findViewById(R.id.list_id);


        lv.setAdapter(new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, model.getIdList()));


        lv.setOnItemClickListener((adapter, itemView, pos, id) -> {
            TextView textView = (TextView) itemView;
            this.model.selectTransaction(Integer.parseInt(textView.getText().toString()));
            ((MainActivity) requireActivity()).showInfo();
        });


        return view;
    }
}
