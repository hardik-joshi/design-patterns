package com.designpattern.builderspattern.builders;

import com.designpattern.builderspattern.cars.Type;
import com.designpattern.builderspattern.components.Engine;
import com.designpattern.builderspattern.components.GPSNavigator;
import com.designpattern.builderspattern.components.Transmission;
import com.designpattern.builderspattern.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
