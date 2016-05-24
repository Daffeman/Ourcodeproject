package com.outsourcify.outsourcify;

import static org.junit.Assert.*;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Andreas Eckhoff on 02/05/2016.
 */


@RunWith(AndroidJUnit4.class)
public class EspressoTest {
        @Rule
        public ActivityTestRule<MainActivity> mActivityRule =
                new ActivityTestRule<>(MainActivity.class);

        @Test
        public void buttonShouldOpenSkype(){
            // Press button
            onView(withId(R.id.call_skype)).perform(click());

            // Check that
            onView(withId(getResourceId("Click"))).check(matches(withText("Done")));
        }

        private static int getResourceId(String s) {
            Context targetContext = InstrumentationRegistry.getTargetContext();
            String packageName = targetContext.getPackageName();
            return targetContext.getResources().getIdentifier(s, "id", packageName);
        }


}