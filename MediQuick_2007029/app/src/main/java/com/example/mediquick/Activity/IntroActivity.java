package com.example.mediquick.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mediquick.databinding.ActivityIntroBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Activity for the introductory screen of the application.
 */
public class IntroActivity extends BaseActivity {

    // Binding for this activity
    private ActivityIntroBinding binding;

    // Singleton instance for FirebaseAuthManager
    private FirebaseAuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable(); // Initialize variables and set listeners
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5")); // Set status bar color
    }

    /**
     * Initialize variables and set listeners for buttons.
     */
    private void setVariable() {
        // Get the Singleton instance of FirebaseAuthManager
        authManager = FirebaseAuthManager.getInstance();

        // Set click listener for login button
        binding.loginBtn.setOnClickListener(v -> {
            if (authManager.getCurrentUser() != null) { // Check if user is logged in
                startActivity(new Intent(IntroActivity.this, MainActivity.class)); // Go to MainActivity
            } else {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class)); // Go to LoginActivity
            }
        });

        // Set click listener for signup button
        binding.signupBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, SignupActivity.class)));
    }

    /**
     * Singleton class for Firebase authentication.
     */
    private static class FirebaseAuthManager {
        private static FirebaseAuthManager instance; // Single instance of FirebaseAuthManager
        private FirebaseAuth mAuth; // FirebaseAuth instance

        // Private constructor to prevent instantiation
        private FirebaseAuthManager() {
            mAuth = FirebaseAuth.getInstance();
        }

        // Method to get the single instance of FirebaseAuthManager
        public static FirebaseAuthManager getInstance() {
            if (instance == null) { // Check if instance is null
                synchronized (FirebaseAuthManager.class) { // Synchronize to ensure thread safety
                    if (instance == null) { // Double-check if instance is still null
                        instance = new FirebaseAuthManager(); // Create new instance
                    }
                }
            }
            return instance; // Return the single instance
        }

        // Method to get the current authenticated user
        public FirebaseUser getCurrentUser() {
            return mAuth.getCurrentUser();
        }

        // Method to sign out the current user
        public void signOut() {
            mAuth.signOut();
        }
    }
}
