package com.example.mediquick.uitesting;

        import androidx.test.espresso.Espresso;
        import androidx.test.espresso.intent.Intents;
        import androidx.test.espresso.intent.rule.IntentsTestRule;
        import com.example.mediquick.Activity.MainActivity;
        import com.example.mediquick.Activity.SignupActivity;
        import com.example.mediquick.R;
        import org.junit.Rule;
        import org.junit.Test;
        import static androidx.test.espresso.Espresso.onView;
        import static androidx.test.espresso.action.ViewActions.click;
        import static androidx.test.espresso.action.ViewActions.typeText;
        import static androidx.test.espresso.assertion.ViewAssertions.matches;
        import static androidx.test.espresso.intent.Intents.intended;
        import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
        import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
        import static androidx.test.espresso.matcher.ViewMatchers.withId;
        import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SignupActivityTest {

    @Rule
    public IntentsTestRule<SignupActivity> intentsTestRule =
            new IntentsTestRule<>(SignupActivity.class);


    @Test
    public void testEmptyFields() {
        // Click on signup button without entering email and password
        onView(withId(R.id.signupBtn)).perform(click());

        // Check if the toast with message "Your Password Must Be 6 At Least Characters" is displayed
        onView(withText("Your Password Must Be 6 At Least Characters"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}

