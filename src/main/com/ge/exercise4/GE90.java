package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 {
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 3;
    public final double flightHoursBeforeRebuild = 25_000;
    public final double dryWeight = 14_502;
    public final double wetWeight = 15_100;
    public final double takeoffThrust = 81_070;

    private double flightHours;  // flight hours engine has after the rebuild
    private int numRebuilds;

    public GE90(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }
    public double getNumRebuilds() {
        return numRebuilds;
    }

    public void setNumRebuilds(int numRebuilds) {
        this.numRebuilds = numRebuilds;
    }
    
    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight; //change
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }
    public double hoursLeftbeforeRebuild() {
    	return flightHoursBeforeRebuild-flightHours;
    	
    }
    public double serviceLifeLeft() {
    	return (maxNumRebuilds - numRebuilds + 1)*flightHoursBeforeRebuild - flightHours;
    }
}
