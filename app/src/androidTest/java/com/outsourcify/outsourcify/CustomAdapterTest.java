package com.outsourcify.outsourcify;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas Eckhoff on 27/05/2016.
 */
public class CustomAdapterTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainActivity;
    private CustomAdapter mCustomAdapter;

    public CustomAdapterTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        mMainActivity = new MainActivity();
        mCustomAdapter = new CustomAdapter(mMainActivity,mMainActivity.prgmNameList,mMainActivity.prgmImages);
    }
    @Test
    public void testCanBeCreated(){
        assertNotNull(mCustomAdapter);
    }

    @Test
    public void testGetMessage() throws Exception {
//        assertEquals(mCustomAdapter.getMessage(8),mCustomAdapter.context.getString(R.string.message_other));
        System.out.println(mCustomAdapter.getMessage(8));
        System.out.println(mCustomAdapter.context.getString(R.string.message_other));
    }

    @Test
    public void testShowDialog() throws Exception {

    }

    @Test
    public void testInitiateSkypeUri() throws Exception {

    }

    @Test
    public void testGetView() throws Exception {

    }
}