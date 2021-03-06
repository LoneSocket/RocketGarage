package fr.lonesocket.garage.app;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> _activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void launchMainActivityTest() {
        Assert.assertNotNull(_activityTestRule.getActivity());
    }
}
