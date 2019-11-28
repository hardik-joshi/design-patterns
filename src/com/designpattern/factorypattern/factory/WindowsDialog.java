package com.designpattern.factorypattern.factory;

import com.designpattern.factorypattern.buttons.Button;
import com.designpattern.factorypattern.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
