package com.example.mediquick.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediquick.Adapter.CartAdapter;
import com.example.mediquick.Helper.ChangeNumberItemsListener;
import com.example.mediquick.Helper.ManagmentCart;
import com.example.mediquick.R;
import com.example.mediquick.databinding.ActivityCartBinding;

/**
 * Activity for managing the shopping cart.
 */
public class CartActivity extends BaseActivity {

    // Binding for this activity
    private ActivityCartBinding binding;

    // Adapter for the RecyclerView
    private RecyclerView.Adapter adapter;

    // Cart management helper
    private ManagmentCart managementCart;

    // Total tax amount
    private double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart=new ManagmentCart(this);

        setVariable();
        calculateCart();
        initList();
    }

    /**
     * Initializes the RecyclerView and sets its adapter.
     */
    private void initList() {
        if (managementCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cardView.setLayoutManager(linearLayoutManager);
        adapter=new CartAdapter(managementCart.getListCart(), this, () -> calculateCart());
        binding.cardView.setAdapter(adapter);
    }

    /**
     * Calculates the total cart amount including tax and delivery.
     */
    private void calculateCart() {
        double percentTax = 0.02; // 2% percent tax
        double delivery = 10; // 10 Dollar

        tax = Math.round(managementCart.getTotalFee() * percentTax * 100.0) / 100;

        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;

        binding.totalFeeTxt.setText("$" + itemTotal);
        binding.taxTxt.setText("$" + tax);
        binding.deliveryTxt.setText("$" + delivery);
        binding.totalTxt.setText("$" + total);
    }

    /**
     * Sets click listener for back button to finish the activity.
     */
    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}
