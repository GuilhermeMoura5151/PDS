/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_2;

import java.util.ArrayList;


/**
 *
 * @author brunop
 */
public class Thermometer {
    /**
     * The current temperature
     */
    protected int current;

    /**
     * The views listening to this thermometer
     */
    protected ArrayList<ThermometerListener> listeners = new ArrayList<ThermometerListener>();

    /**
     * Create a new thermometer.
     *
     * @param cur temperature to display
     */
    public Thermometer(int cur) {
        current = cur;
    }

    /**
     * Displays the temperature passed in.
     *
     * @param cur the temperature to display.
     */
    public void setCurrent(int cur) {
        current = cur;
        notifyListeners();
    }

    /**
     * Add a listener
     *
     * @param l the listener to add
     */
    public void addThermometerListener(ThermometerListener l) {
        listeners.add(l);
    }

    /**
     * Remove a listener
     *
     * @param l the listener to remove
     */
    public void removeThermometerListener(ThermometerListener l) {
        listeners.remove(l);
    }

    /**
     * Notify the listeners of a change to the temperature
     */
    protected void notifyListeners() {
        for (ThermometerListener l : listeners) {
            l.temperatureChanged();
        }
    }

    /**
     * @return the temperature used by the thermometer
     */
    public int getTemperature() {
        return current;
    }
}
    
