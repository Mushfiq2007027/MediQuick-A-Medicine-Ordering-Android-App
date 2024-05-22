package com.example.mediquick.uitesting;

import android.content.Intent;
import android.util.Log;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import com.example.mediquick.Activity.LoginActivity;
import com.example.mediquick.Activity.MainActivity;
import com.example.mediquick.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public IntentsTestRule<LoginActivity> intentsTestRule =
            new IntentsTestRule<>(LoginActivity.class);



    @Test
    public void testLoginFailure() {
        // Input invalid email and password
        onView(withId(R.id.userEdt)).perform(typeText("invalid_email@example.com"));
        onView(withId(R.id.passEdt)).perform(typeText("invalid_password"));

        // Close soft keyboard
        Espresso.closeSoftKeyboard();

        // Click on login button
        onView(withId(R.id.loginBtn)).perform(click());

        // Check if the toast with message "Authentication Failed" is displayed
        onView(withText("Authentication Failed"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }


}
