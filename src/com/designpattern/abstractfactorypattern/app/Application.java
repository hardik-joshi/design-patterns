package com.designpattern.abstractfactorypattern.app;


import com.designpattern.abstractfactorypattern.buttons.Button;
import com.designpattern.abstractfactorypattern.checkboxes.Checkbox;
import com.designpattern.abstractfactorypattern.factories.GUIFactory;

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
