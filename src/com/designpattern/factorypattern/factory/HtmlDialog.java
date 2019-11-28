package com.designpattern.factorypattern.factory;

import com.designpattern.factorypattern.buttons.Button;
import com.designpattern.factorypattern.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
