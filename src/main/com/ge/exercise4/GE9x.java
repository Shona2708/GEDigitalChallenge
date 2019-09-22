package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE9x {
	private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GE9x.class.getSimpleName();
    private final String serialNumber;
    public final int maxNumRebuilds = 5;
    public final double flightHoursBeforeRebuild = 30_000;
    public final double dryWeight = 15_505;
    public final double wetWeight = 15_900;
    public final double takeoffThrust = 100_000;
    private double flightHours; // flight hours engine has after the rebuild
    private int numRebuilds;

    public GE9x(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE9x(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE9x(String serialNumber) {
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
        return takeoffThrust / dryWeight;
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
