package com.outsourcify.outsourcify;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas Eckhoff on 27/05/2016.
 */
public class JaConfirmationActivityTest {
    private ConfirmationActivity mConfirmationActivity;

    @Before
    public void setUp() throws Exception {
    mConfirmationActivity = new ConfirmationActivity();
    }

    @Test
    public void testConfirmationActivityCanBeCreated(){
        assertNotNull(mConfirmationActivity);
    }
    @Test
    public void testOnCreate() throws Exception {

    }

    @Test
    public void testSendMail() throws Exception {

    }

    @Test
    public void testGetGPSLocation() throws Exception {

    }

    @Test
    public void testAdditionalInformation() throws Exception {

    }

    @Test
    public void testReturnHome() throws Exception {

    }

}