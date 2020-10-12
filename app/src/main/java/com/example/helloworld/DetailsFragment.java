package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailsFragment extends Fragment {
    private TransactionViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView trId = view.findViewById(R.id.tr_id);
        TextView trAmount = view.findViewById(R.id.tr_amount);
        TextView trDesc = view.findViewById(R.id.tr_description);

        this.viewModel = new ViewModelProvider(requireActivity()).get(TransactionViewModel.class);
        this.viewModel.getSelectedTransaction().observe(getViewLifecycleOwner(), item -> {
            Transaction tr = viewModel.getTransactionDetails(item);

            trId.setText("Id : " + tr.getId());
            trAmount.setText("Amount : " + tr.getAmount());
            trDesc.setText("Brand : " + tr.getDescription());
        });

        return view;
    }
}
