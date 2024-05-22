package com.example.mediquick.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediquick.Adapter.MedicineListAdapter;
import com.example.mediquick.Domain.Medicines;
import com.example.mediquick.R;
import com.example.mediquick.databinding.ActivityListMedicinesBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * This activity displays a list of medicines based on category or search query.
 */
public class ListMedicinesActivity extends BaseActivity {

    ActivityListMedicinesBinding binding;
    private RecyclerView.Adapter adapterListMedicine;
    private int categoryId;
    private String categoryName;
    private String searchText;
    private boolean isSearch;
    private DataServiceFactory dataServiceFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityListMedicinesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentExtra();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Medicines");
        dataServiceFactory = new DataServiceFactory(databaseReference);
        initList();
        setVariable();
    }

    /**
     * Additional variable settings can be added here.
     */
    private void setVariable() {
        // Additional variable settings can be added here
    }

    /**
     * Initializes the medicine list based on category or search query.
     */
    private void initList() {
        DataService dataService = dataServiceFactory.getDataService();
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<Medicines> list=new ArrayList<>();
        Query query;
        if (isSearch){
            query = dataService.getSearchQuery(searchText);
        } else {
            query = dataService.getCategoryQuery(categoryId);
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(Medicines.class));
                    }
                    if (list.size()>0){
                        binding.medicineListView.setLayoutManager(new GridLayoutManager(ListMedicinesActivity.this,2));
                        adapterListMedicine=new MedicineListAdapter(list);
                        binding.medicineListView.setAdapter(adapterListMedicine);
                    }
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }

    /**
     * Retrieves intent extras such as category ID, category name, search text, and search indicator.
     */
    private void getIntentExtra() {
        categoryId=getIntent().getIntExtra("CategoryId", 0);
        categoryName=getIntent().getStringExtra("CategoryName");
        searchText=getIntent().getStringExtra("text");
        isSearch=getIntent().getBooleanExtra("isSearch",false);

        binding.titleTxt.setText(categoryName);
        binding.backBtn.setOnClickListener(v -> finish());
    }
}

/**
 * Interface for defining data service methods.
 */
interface DataService {
    Query getCategoryQuery(int categoryId);
    Query getSearchQuery(String searchText);
}

/**
 * Concrete implementation of DataService interface for Firebase.
 */
class FirebaseDataService implements DataService {
    private DatabaseReference myRef;

    public FirebaseDataService(DatabaseReference myRef) {
        this.myRef = myRef;
    }

    @Override
    public Query getCategoryQuery(int categoryId) {
        return myRef.orderByChild("CategoryId").equalTo(categoryId);
    }

    @Override
    public Query getSearchQuery(String searchText) {
        return myRef.orderByChild("Title").startAt(searchText).endAt(searchText+'\uf8ff');
    }
}

/**
 * Factory class for creating DataService instances.
 */
class DataServiceFactory {
    private DatabaseReference databaseReference;

    /**
     * Constructor to initialize with DatabaseReference.
     * @param databaseReference The reference to the Firebase database.
     */
    public DataServiceFactory(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    /**
     * Creates and returns a new DataService instance.
     * @return A new DataService instance.
     */
    public DataService getDataService() {
        return new FirebaseDataService(databaseReference);
    }
}
