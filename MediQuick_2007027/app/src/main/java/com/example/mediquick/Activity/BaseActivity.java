/**
 * BaseActivity is a custom AppCompatActivity class that serves as the base class for other activities in the application.
 * It provides common functionality such as handling Firebase authentication and database instances.
 */
package com.example.mediquick.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mediquick.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    private static FirebaseAuth mAuth;
    private static FirebaseDatabase database;
    public String TAG = "Mushfiq_Fatin";

    /**
     * Called when the activity is starting. This is where most initialization should go.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ensure single instance of FirebaseAuth and FirebaseDatabase
        mAuth = getFirebaseAuthInstance();
        database = getFirebaseDatabaseInstance();

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }

    /**
     * Singleton pattern for FirebaseAuth.
     * @return The instance of FirebaseAuth.
     */
    public static FirebaseAuth getFirebaseAuthInstance() {
        if (mAuth == null) {
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }

    /**
     * Singleton pattern for FirebaseDatabase.
     * @return The instance of FirebaseDatabase.
     */
    public static FirebaseDatabase getFirebaseDatabaseInstance() {
        if (database == null) {
            // Access FirebaseDatabase instance through its getInstance() method
            database = FirebaseDatabase.getInstance();
        }
        return database;
    }
}
