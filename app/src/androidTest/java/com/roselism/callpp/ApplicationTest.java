package com.roselism.callpp;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.roselism.callpp.util.ConfigUtil;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">
 * Testing Fundamentals
 * </a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testGetAppKey() {
        try {
            assertEquals("125fd0563b954", ConfigUtil.getAppKey("mob"));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}