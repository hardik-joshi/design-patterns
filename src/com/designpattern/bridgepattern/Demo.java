package com.designpattern.bridgepattern;

import com.designpattern.bridgepattern.devices.Device;
import com.designpattern.bridgepattern.devices.Radio;
import com.designpattern.bridgepattern.devices.Tv;
import com.designpattern.bridgepattern.remotes.AdvancedRemote;
import com.designpattern.bridgepattern.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    private static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
