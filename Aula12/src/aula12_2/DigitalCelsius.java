/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_2;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author brunop
 */
public class DigitalCelsius extends JPanel implements ThermometerListener {
    private static final long serialVersionUID = -7759788299828653780L;

    // The label displaying the temperature
    private JLabel tempLabel;

    // The Unicode symbol for degrees
    private static final char DEGREE_SYMBOL = '\u00B0';

    /**
     * The thermometer whose temperature is being displayed
     */
    protected Thermometer thermometer;

    /**
     * Creates a digital thermometer
     *
     * @param t the thermometer whose temperature is displayed
     */
    public DigitalCelsius(Thermometer t) {
        thermometer = t;

        JPanel tempPanel = new JPanel();
        tempLabel = new JLabel(getDisplayString());
        tempLabel.setFont(tempLabel.getFont().deriveFont(20.0f));
        tempPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        tempPanel.add(tempLabel);
        add(tempPanel);
    }

    /**
     * Create the string to display in the thermometer
     *
     * @return the string to display in the thermometer
     */
    private String getDisplayString() {
        double temperature = (thermometer.getTemperature() - 32) * 5 / 9;
        return "" + temperature + DEGREE_SYMBOL + "C";
    }

    /**
     * Change the temperature displayed
     */
    @Override
    public void temperatureChanged() {
        tempLabel.setText(getDisplayString());
        repaint();
    }

    
}
