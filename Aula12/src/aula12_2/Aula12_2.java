/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_2;
        
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author brunop
 */
public class Aula12_2 {
    
    /**
     * This class displays a mercury and digital thermometer.  The user can change 
     * the temperature displayed by entering a value in the text field.
     */

            /**
             * The main program creates the user interface for the thermometer
             * application and creates an initial thermometer.
             * @param args None expected.
             */
    public static void main(String[] args) {
        // Create the thermometer.
        int startingTemp = 50;

        final Thermometer thermometer = new Thermometer (startingTemp);

        // Create the frame
        JFrame frame = new JFrame ("Thermometer");
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create the panel where the user can type in a new temperature.
        JPanel valuePanel = new JPanel();

        valuePanel.add (new JLabel ("Enter a temperature to display"));
        JTextField tempField = new JTextField (5);
        tempField.addActionListener (new ActionListener () {

                @Override
                public void actionPerformed(ActionEvent event) {
                        try {
                                int newTemp = Integer.parseInt (((JTextField) event.getSource()).getText());
                                thermometer.setCurrent (newTemp);
                        } catch (NumberFormatException e) {
                                // Ignore anything other than integers
                        }
                }
        });
        valuePanel.add(tempField);
        mainPanel.add (valuePanel);

        // Create the views
        MercuryDisplay thermometerDisplay = new MercuryDisplay(-10, 120, thermometer);
        DigitalDisplay thermometerDisplay2 = new DigitalDisplay(thermometer);
        DigitalCelsius thermometerDisplay3 = new DigitalCelsius(thermometer);
        DigitalMaxTemperature thermometerDisplay4 = new DigitalMaxTemperature(thermometer);
        

        // Add the views to the display
        mainPanel.add(thermometerDisplay);
        mainPanel.add(thermometerDisplay2);
        mainPanel.add(thermometerDisplay3);
        mainPanel.add(thermometerDisplay4);

        // Get the views to listen to the model
        thermometer.addThermometerListener(thermometerDisplay);
        thermometer.addThermometerListener(thermometerDisplay2);
        thermometer.addThermometerListener(thermometerDisplay3);
	thermometer.addThermometerListener(thermometerDisplay4);

        // Display the frame
        frame.pack();
        frame.setVisible (true);
    }
	
}

