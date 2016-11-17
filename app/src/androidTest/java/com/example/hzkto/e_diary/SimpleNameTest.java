package com.example.hzkto.e_diary;

import android.app.Activity;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ActivityInstrumentationTestCase2;

import com.example.hzkto.e_diary.database.DBMain;
import com.example.hzkto.e_diary.database.DBSingletone;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by hzkto on 11/17/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleNameTest extends ActivityInstrumentationTestCase2<MainActivity> {
    String login;

    //настройка класса
    public SimpleNameTest() {
        super(MainActivity.class);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
        login = "liza_ageeva";
        getActivity();
    }

    Activity getCurrentActivity() throws Throwable {
        getInstrumentation().waitForIdleSync();
        final Activity[] activity = new Activity[1];
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                java.util.Collection<Activity> activites = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                activity[0] = Iterables.getOnlyElement(activites);
            }
        });
        return activity[0];
    }



    //тесты

    //тест введенного текста в поле логин
    public void test_1_EnterText() throws Exception {
        onView(withId(R.id.fragmentLogin_tvLogin)).perform(typeText("Elizaveta Ageeva"));
        onView(withId(R.id.fragmentLogin_tvLogin)).check(matches(withText("Elizaveta Ageeva")));
    }

    //тест на авторизацию админа
    public void test_2_AuthorizationAdmin() throws Exception {
        onView(withId(R.id.fragmentLogin_tvLogin)).perform(typeText("admin"));
//        onView(withId(R.id.fragmentLogin_tvPassword)).perform(click());
        onView(withId(R.id.fragmentLogin_tvPassword)).perform(typeText("1234"));
        onView(withId(R.id.fragmentLogin_btnLogin)).perform(click());
        String currentActivity = null;
        try {
            currentActivity = getCurrentActivity().getClass().getSimpleName();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        assertEquals("AdminActivity", currentActivity);

    }

    //тест на добавление записи в БД
    public void test_3_Registration() throws Exception {
        onView(withId(R.id.fragmentLogin_btnRegister)).perform(click());
        onView(withId(R.id.fragmentRegister_tvLogin)).perform(typeText(login));
        onView(withId(R.id.fragmentRegister_tvPassword)).perform(typeText("1111"));
        onView(withId(R.id.fragmentRegister_tvName)).perform(typeText("Elizaveta"));
        onView(withId(R.id.fragmentRegister_tvMidname)).perform(typeText("Aleksandrovna"));

        onView(withId(R.id.fragmentRegister_tvEmail)).perform(scrollTo());

        onView(withId(R.id.fragmentRegister_tvLastname)).perform(typeText("Ageeva"));
        onView(withId(R.id.fragmentRegister_tvEmail)).perform(typeText("liza@mail.ru"));

        onView(withId(R.id.fragmentRegister_btnRegister)).perform(scrollTo());

        onView(withId(R.id.fragmentRegister_tvBirthday)).perform(typeText("22.05.1996"));
        onView(withId(R.id.fragmentRegister_btnRegister)).perform(click());

        DBMain dbMain = new DBMain();
        try {
            dbMain = DBSingletone.getHelper().getDbMainDAO().queryForId(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //чтобы сломать
//        dbMain = null;
        assertNotSame(null, dbMain);

    }

    //тест на авторизацию пользователя
    public void test_4_AuthorizationUser() throws Exception {
        onView(withId(R.id.fragmentLogin_tvLogin)).perform(typeText(login));
        onView(withId(R.id.fragmentLogin_tvPassword)).perform(typeText("1111"));
        onView(withId(R.id.fragmentLogin_btnLogin)).perform(click());
        String currentActivity = null;
        try {
            currentActivity = getCurrentActivity().getClass().getSimpleName();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        assertEquals("UserActivity", currentActivity);

    }

}
