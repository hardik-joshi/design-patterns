package com.designpattern.abstractfactorypattern.factories;

import com.designpattern.abstractfactorypattern.buttons.Button;
import com.designpattern.abstractfactorypattern.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
