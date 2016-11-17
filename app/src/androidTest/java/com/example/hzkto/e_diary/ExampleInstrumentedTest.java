package com.example.hzkto.e_diary;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.example.hzkto.e_diary.database.DBMain;
import com.example.hzkto.e_diary.database.DBSingletone;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //тест на проверку имени пакета (полного названия приложения)
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = getTargetContext();
        assertEquals("com.example.hzkto.e_diary", appContext.getPackageName());
    }

    //тест на добавление записи в БД
    @Test
    public void dataBaseAdd() throws Exception {
        // Context of the app under test.
        long countBefore = DBSingletone.getHelper().getDbMainDAO().countOf();

        DBMain dbMain = new DBMain();
        dbMain.setBirthday("11.01.1997");
        dbMain.setEmail("123@123.123");
        dbMain.setLastname("qwe");
        dbMain.setLogin("51651");
        dbMain.setMidname("123");
        dbMain.setName("123");
        dbMain.setBirthday("123");
        dbMain.setPassword("qqqq");
        DBSingletone.getHelper().getDbMainDAO().create(dbMain);

        long countAfter = DBSingletone.getHelper().getDbMainDAO().countOf();

        assertEquals(countBefore + 1, countAfter);
    }

    //тест на наличие логина в БД
    @Test
    public void dataBaseLoginExists() throws Exception {
        // Context of the app under test.
        String login = "admin";
        DBMain dbMain = DBSingletone.getHelper().getDbMainDAO().queryForId(login);

        assertNotEquals(null, dbMain);
    }
}
