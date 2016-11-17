package com.example.hzkto.e_diary;

import android.content.Context;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.AutoCompleteTextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest extends AndroidTestCase {
    private AutoCompleteTextView tvLogin;
    private View view;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = getTargetContext();

        assertEquals("com.example.hzkto.e_diary", appContext.getPackageName());
    }

    @Before
    public void setUp() throws Exception {
//        mainActivity = new MainActivity();
    }
}
