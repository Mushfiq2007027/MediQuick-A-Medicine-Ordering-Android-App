package com.example.mediquick.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mediquick.R;
import com.example.mediquick.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * This activity allows users to log in to the application.
 */
public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Using Factory to get FirebaseAuth instance
        mAuth = FirebaseAuthFactory.getInstance().getFirebaseAuth();
        setVariable();
    }

    /**
     * Sets up the variables and event listeners.
     */
    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(LoginActivity.this, "Please Fill Up Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/**
 * Factory class responsible for creating instances of FirebaseAuth.
 */
class FirebaseAuthFactory {
    private static FirebaseAuthFactory instance;
    private FirebaseAuth mAuth;

    // Private constructor to prevent direct instantiation
    private FirebaseAuthFactory() {
        mAuth = FirebaseAuth.getInstance(); // Creating FirebaseAuth instance
    }

    /**
     * Gets the instance of FirebaseAuthFactory using Singleton pattern.
     * @return The instance of FirebaseAuthFactory.
     */
    public static synchronized FirebaseAuthFactory getInstance() {
        if (instance == null) {
            instance = new FirebaseAuthFactory(); // Creating instance if not already exists
        }
        return instance;
    }

    /**
     * Gets the FirebaseAuth instance.
     * @return The FirebaseAuth instance.
     */
    public FirebaseAuth getFirebaseAuth() {
        return mAuth;
    }
}
