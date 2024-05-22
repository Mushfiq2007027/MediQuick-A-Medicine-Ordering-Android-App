package com.example.mediquick.Activity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mediquick.Domain.Medicines;
import com.example.mediquick.Helper.ManagmentCart;
import com.example.mediquick.R;
import com.example.mediquick.databinding.ActivityDetailBinding;

/**
 * Activity to display details of a medicine.
 */
public class DetailActivity extends BaseActivity {

    // Binding for this activity
    ActivityDetailBinding binding;

    // Medicine object to display details
    private Medicines object;

    // Number of items selected
    private int num = 1;

    // Cart management helper
    private ManagmentCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();

    }

    /**
     * Initializes variables and sets up UI elements.
     */
    private void setVariable() {
        managementCart = new ManagmentCart(this);

        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("$" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar() + " Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText((num * object.getPrice() + "$"));

        binding.plusBtn.setOnClickListener(v -> {
            num = num + 1;
            binding.numTxt.setText(num + " ");
            binding.totalTxt.setText("$" + (num * object.getPrice()));
        });

        binding.minusBtn.setOnClickListener(v -> {
            if (num > 1) {
                num = num - 1;
                binding.numTxt.setText(num + "");
                binding.totalTxt.setText("$" + (num * object.getPrice()));
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managementCart.insertMedicine(object);
        });
    }

    /**
     * Retrieves the Medicine object from the Intent extras.
     */
    private void getIntentExtra() {
        object = (Medicines) getIntent().getSerializableExtra("object");
    }
}
