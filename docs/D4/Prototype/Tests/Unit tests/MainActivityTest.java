package com.outsourcify.outsourcify;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.replaceText;


import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.instanceOf;
//import static org.hamcrest.Matchers.is;

/**
 * To run with gradle, use the terminal and type: "gradlew connectedAndroidTest".
 *
 * Created by Andreas Eckhoff on 27/05/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void firstErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(0)
                .perform(click());

        onView(withText("Försening")).check(matches(isDisplayed()));
    }

    @Test
    public void secondErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(1)
                .perform(click());

        onView(withText("Laddningsfel")).check(matches(isDisplayed()));
    }

    @Test
    public void thirdErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(2)
                .perform(click());

        onView(withText("Platsbrist")).check(matches(isDisplayed()));
    }

    @Test
    public void fourthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(3)
                .perform(click());

        onView(withText("Motorfel")).check(matches(isDisplayed()));
    }

    @Test
    public void fifthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(4)
                .perform(click());

        onView(withText("Yttre skada")).check(matches(isDisplayed()));
    }

    @Test
    public void sixthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(5)
                .perform(click());

        onView(withText("Klimatfel")).check(matches(isDisplayed()));
    }

    @Test
    public void seventhErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(6)
                .perform(click());

        onView(withText("Biljettautomatsfel")).check(matches(isDisplayed()));
    }

    @Test
    public void eigthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Dörrfel")).check(matches(isDisplayed()));
    }

    @Test
    public void ninthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(8)
                .perform(click());

        onView(withText("Övrigt fel")).check(matches(isDisplayed()));
    }

    @Test
    public void tenthErrorButtonTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(10) //position 9 is a hidden button for layout purposes
                .perform(click());

        onView(withText("Trafikledning")).check(matches(isDisplayed()));
    }


    @Test
    public void firstErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(0)
                .perform(click());

        onView(withText("0-5 minuter")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("0-5 minuter försenad"))));
    }

    @Test
    public void firstErrorButtonSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(0)
                .perform(click());

        onView(withText("6-10 minuter")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("6-10 minuter försenad"))));
    }

    @Test
    public void firstErrorButtonThirdChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(0)
                .perform(click());

        onView(withText("10+ minuter")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("10+ minuter försenad"))));
    }

    @Test
    public void secondErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(1)
                .perform(click());

        onView(withText("Laddaren kommer inte ner")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Laddaren kommer inte ner"))));
    }

    @Test
    public void secondErrorButtonSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(1)
                .perform(click());

        onView(withText("Laddaren lossnar inte")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Laddaren lossnar inte"))));
    }

    @Test
    public void thirdErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(2)
                .perform(click());

        onView(withText("OK")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Platsbrist"))));
    }

    @Test
    public void fourthErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(3)
                .perform(click());

        onView(withText("OK")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Motorfel"))));
    }

    @Test
    public void fifthErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(4)
                .perform(click());

        onView(withText("OK")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Yttre skada"))));
    }

    @Test
    public void sixthErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(5)
                .perform(click());

        onView(withText("För varmt")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Klimatfel: För varmt"))));
    }

    @Test
    public void sixthErrorButtonSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(5)
                .perform(click());

        onView(withText("För kallt")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Klimatfel: För kallt"))));
    }

    @Test
    public void seventhErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(6)
                .perform(click());

        onView(withText("Fram")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Biljettautomatsfel: Fram"))));
    }

    @Test
    public void seventhErrorButtonSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(6)
                .perform(click());

        onView(withText("Mitten")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Biljettautomatsfel: Mitten"))));
    }

    @Test
    public void seventhErrorButtonThirdChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(6)
                .perform(click());

        onView(withText("Bak")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Biljettautomatsfel: Bak"))));
    }

    @Test
    public void eigthErrorButtonFirstAndFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Fram")).perform(click());
        onView(withText("Går inte att öppna")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Fram: Går inte att öppna"))));
    }

    @Test
    public void eigthErrorButtonSecondAndFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Mitten")).perform(click());
        onView(withText("Går inte att öppna")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Mitten: Går inte att öppna"))));
    }

    @Test
    public void eightErrorButtonThirdAndFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Bak")).perform(click());
        onView(withText("Går inte att öppna")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Bak: Går inte att öppna"))));
    }

    @Test
    public void eigthErrorButtonFirstAndSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Fram")).perform(click());
        onView(withText("Går inte att stänga")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Fram: Går inte att stänga"))));
    }

    @Test
    public void eigthErrorButtonSecondAndSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Mitten")).perform(click());
        onView(withText("Går inte att stänga")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Mitten: Går inte att stänga"))));
    }

    @Test
    public void eightErrorButtonThirdAndSecondChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(7)
                .perform(click());

        onView(withText("Bak")).perform(click());
        onView(withText("Går inte att stänga")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Dörrfel: Bak: Går inte att stänga"))));
    }

    @Test
    public void ninthErrorButtonFirstChoiceTest(){
        onData(anything())
                .inAdapterView(withId(R.id.gridView)).atPosition(8)
                .perform(click());

        onView(isAssignableFrom(EditText.class)).perform(replaceText("Åäö!%"), closeSoftKeyboard());
        onView(withText("OK")).perform(click());
        onView(withText(startsWith("Tack för din inrapportering!"))).check(matches(withText(endsWith("Övrigt fel: Åäö!%"))));
    }
}