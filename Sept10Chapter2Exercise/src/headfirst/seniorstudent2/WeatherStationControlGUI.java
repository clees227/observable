/*
 * WeatherStationControlGUI.java 1.0 Sept 10, 2015
 *
 * Copyright (c) 2015 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */
package headfirst.seniorstudent2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WeatherStationControlGUI extends JFrame {

  private JTextField humidityTextField;
  private JTextField pressureTextField;
  private JTextField temperatureTextField;
  private JButton updateButton;
  private WeatherData weatherData;

  public WeatherStationControlGUI(WeatherData weatherData) {
    this.setTitle("Control GUI");
    this.weatherData = weatherData;
    createGui();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  private void createGui() {
    Container container = this.getContentPane();
    JPanel holdGrid = new JPanel();
    JPanel leftGrid = new JPanel();
    JPanel rightGrid = new JPanel();
    JPanel buttonPanel = new JPanel();

    leftGrid.setLayout(new GridLayout(3, 1));
    leftGrid.add(new JLabel("Temperature ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Humidity ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Pressure ", SwingConstants.RIGHT));

    rightGrid.setLayout(new GridLayout(3, 1));
    rightGrid.add(temperatureTextField = new JTextField("0", 10));
    rightGrid.add(humidityTextField = new JTextField("0", 10));
    rightGrid.add(pressureTextField = new JTextField("0", 10));

    buttonPanel.add(updateButton = new JButton("Update"));
    holdGrid.setLayout(new BorderLayout(5, 0));
    holdGrid.add(leftGrid, BorderLayout.WEST);
    holdGrid.add(rightGrid, BorderLayout.CENTER);
    container.add(holdGrid, BorderLayout.CENTER);
    container.add(buttonPanel, BorderLayout.SOUTH);

    updateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        weatherData.setMeasurements(Float.parseFloat(temperatureTextField.getText()),
                                    Float.parseFloat(humidityTextField.getText()),
                                    Float.parseFloat(pressureTextField.getText()));
      }
    });
  }
}
