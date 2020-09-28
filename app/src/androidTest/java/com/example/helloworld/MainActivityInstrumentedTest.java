package com.example.helloworld;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mMainActivityTestRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.helloworld", appContext.getPackageName());
    }

    @Test
    public void checkAdd() throws Exception {
        onView(withId(R.id.editA))
                .perform(replaceText("2"), closeSoftKeyboard());

        onView(withId(R.id.editB))
                .perform(replaceText("4"), closeSoftKeyboard());

        onView(withId(R.id.add))
                .perform(click());

        onView(withId(R.id.textView3))
                .check(matches(withText("6")));
    }
}