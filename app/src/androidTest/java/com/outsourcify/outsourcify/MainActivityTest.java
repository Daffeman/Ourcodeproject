package com.outsourcify.outsourcify;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas Eckhoff on 27/05/2016.
 */
public class MainActivityTest {
    private MainActivity mMainActivity;
    @Before
    public void setUp() throws Exception {
    mMainActivity = new MainActivity();
    }
    @Test
    public void testCanBeCreated(){
        assertNotNull(mMainActivity);
    }

}