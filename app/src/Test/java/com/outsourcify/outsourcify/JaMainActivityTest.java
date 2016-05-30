package com.outsourcify.outsourcify;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas Eckhoff on 27/05/2016.
 */
public class JaMainActivityTest {

    private MainActivity mMainActivity;
    @Before

    public void Initialize() throws Exception {
//        android.os.Process.getThreadPriority(android.os.Process.myTid());
        mMainActivity = new MainActivity();
    }
    @Test
    public void testCanBeCreated(){
        assertNotNull(mMainActivity);
    }

}