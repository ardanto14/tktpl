package com.example.helloworld;

import java.util.HashMap;

public class TransactionRepository {
    private Integer[] id;
    private HashMap<Integer, Transaction> transactionDetails;

    public Integer[] getId() {
        return id;
    }

    public Transaction getTransactionDetails(int id){
        if(transactionDetails == null){
            createTranscationDetails();
        }
        return transactionDetails.get(id);
    }

    public void createTranscationDetails(){
        transactionDetails = new HashMap<Integer, Transaction>();
        id = new Integer[10];

        for (int i = 0; i < 10; i++) {
            Transaction transaction = new Transaction();
            transaction.setId(i);
            transaction.setAmount(i * 10000);
            transaction.setDescription("Contoh deskripsi " + Integer.toString(i));

            transactionDetails.put(i, transaction);

            id[i] = i;
        }
    }
}
