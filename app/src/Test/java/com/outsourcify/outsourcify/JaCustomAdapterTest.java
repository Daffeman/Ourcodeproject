package com.outsourcify.outsourcify;

import android.app.Service;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.*;

/**
 * Created by Andreas Eckhoff on 27/05/2016.
 */
public class JaCustomAdapterTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainActivity;
    private CustomAdapter mCustomAdapter;
    private Context serviceMock;
    public JaCustomAdapterTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        serviceMock = Mockito.mock(MainActivity.class);
        serviceMock.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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