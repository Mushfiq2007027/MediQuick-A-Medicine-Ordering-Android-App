package com.example.mediquick.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mediquick.R;
import com.example.mediquick.databinding.ActivitySignupBinding;
import com.google.firebase.auth.FirebaseAuth;

/**
 * This activity handles the user signup process.
 */
public class SignupActivity extends BaseActivity {

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    /**
     * Sets up the event listener for the signup button.
     */
    private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();

            if (password.length() < 6) {
                Toast.makeText(SignupActivity.this, "Your Password Must Be 6 At Least Characters", Toast.LENGTH_SHORT).show();
                return;
            }

            // Use the Factory Method pattern to get an instance of FirebaseAuth
            FirebaseAuth mAuth = FirebaseAuthFactory.createFirebaseAuth();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
                if (task.isSuccessful()) {
                    Log.i("SignupActivity", "onComplete: ");
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                } else {
                    Log.i("SignupActivity", "failure: " + task.getException());
                    Toast.makeText(SignupActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    /**
     * Factory class to encapsulate the creation of FirebaseAuth instances.
     */
    private static class FirebaseAuthFactory {

        /**
         * Factory method to create and return an instance of FirebaseAuth.
         * @return A FirebaseAuth instance.
         */
        public static FirebaseAuth createFirebaseAuth() {
            return FirebaseAuth.getInstance();
        }
    }
}
