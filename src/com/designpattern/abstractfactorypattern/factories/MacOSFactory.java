package com.designpattern.abstractfactorypattern.factories;

import com.designpattern.abstractfactorypattern.buttons.Button;
import com.designpattern.abstractfactorypattern.buttons.MacOSButton;
import com.designpattern.abstractfactorypattern.checkboxes.Checkbox;
import com.designpattern.abstractfactorypattern.checkboxes.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
