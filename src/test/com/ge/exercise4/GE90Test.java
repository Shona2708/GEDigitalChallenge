package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE90Test {

    GE90 testEngine;

    @Before
    public void setUp() {
        testEngine = new GE90("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE90 SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    
    @Test
    public void serviceLifeLeft() {
    	testEngine=new GE90("0001", 5000, 2);  	
        assertEquals((testEngine.maxNumRebuilds - testEngine.getNumRebuilds() + 1)*testEngine.flightHoursBeforeRebuild - testEngine.getFlightHours(), testEngine.serviceLifeLeft(), 0.01);
    }
    @Test
    public void hoursLeftbeforeRebuild() {
    	testEngine=new GE90("0001", 5000);  	
        assertEquals(testEngine.flightHoursBeforeRebuild-testEngine.getFlightHours(), testEngine.hoursLeftbeforeRebuild(), 0.01);
    }
   
}