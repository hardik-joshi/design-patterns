package com.designpattern.abstractfactorypattern;

import com.designpattern.abstractfactorypattern.app.Application;
import com.designpattern.abstractfactorypattern.factories.GUIFactory;
import com.designpattern.abstractfactorypattern.factories.MacOSFactory;
import com.designpattern.abstractfactorypattern.factories.WindowsFactory;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if ("mac".contains(osName)) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
