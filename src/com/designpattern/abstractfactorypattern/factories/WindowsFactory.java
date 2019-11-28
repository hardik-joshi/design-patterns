package com.designpattern.abstractfactorypattern.factories;

import com.designpattern.abstractfactorypattern.buttons.Button;
import com.designpattern.abstractfactorypattern.buttons.WindowsButton;
import com.designpattern.abstractfactorypattern.checkboxes.Checkbox;
import com.designpattern.abstractfactorypattern.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
