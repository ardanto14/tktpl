package com.example.helloworld;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransactionViewModel extends ViewModel {
    private final MutableLiveData<Integer> selectedTransaction = new MutableLiveData<Integer>();

    private TransactionRepository repository = new TransactionRepository();

    public void selectTransaction(int id) {
        selectedTransaction.setValue(id);
    }

    public MutableLiveData<Integer> getSelectedTransaction() {
        return selectedTransaction;
    }

    public Integer[] getIdList(){
        return repository.getId();
    }

    public Transaction getTransactionDetails(int id){
        return repository.getTransactionDetails(id);
    }
}
