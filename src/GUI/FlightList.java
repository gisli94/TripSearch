/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JComponent;

/**
 *
 * @author skulii
 */
public class FlightList {
    
    private static functionality.flight.Flight selectedFlight;
    private static javax.swing.JPanel selectedFlightFrame;
    
    // Returns a JPanel with the flight results from flights
    public static javax.swing.JPanel displayFlights(functionality.flight.Flight[] flights, javax.swing.JPanel container) {
        selectedFlight = null;
        selectedFlightFrame = null;
        
        javax.swing.JPanel[] flightPanels = new javax.swing.JPanel[flights.length];
        for (int i=0;i<flights.length;i++) {
            flightPanels[i] = createTicket(flights[i]);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(container);
        container.setLayout(layout);
            
        javax.swing.GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        for (JComponent flightPanel : flightPanels) {
            horizontalGroup.addComponent(flightPanel);
        }
        layout.setHorizontalGroup(horizontalGroup);
        javax.swing.GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addContainerGap();
        for (JComponent flightPanel : flightPanels) {
            verticalGroup.addComponent(flightPanel);
            verticalGroup.addGap(0, 10, Short.MAX_VALUE);
        }
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addGroup(verticalGroup));
        
        return container;
    }
    
    // Creates a ticket with information about hotel h
    private static javax.swing.JPanel createTicket(functionality.flight.Flight f) {
        javax.swing.JPanel Flight = new javax.swing.JPanel();
        javax.swing.JLabel departureLocation = new javax.swing.JLabel();
        javax.swing.JLabel arrivalLocation = new javax.swing.JLabel();
        javax.swing.JLabel departureTime = new javax.swing.JLabel();
        javax.swing.JLabel airline = new javax.swing.JLabel();
        javax.swing.JLabel price = new javax.swing.JLabel();

        Flight.setBackground(new java.awt.Color(153, 153, 255));
        Flight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightMouseClicked(evt, Flight, f);
            }
        });

        departureLocation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        departureLocation.setText(f.getDeparture());

        arrivalLocation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        arrivalLocation.setText(f.getArrival());

        departureTime.setText(f.getDateAndTime().toString());

        airline.setText(f.getCompany());

        price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        price.setText(String.valueOf(f.getStartPrice()));

        javax.swing.GroupLayout FlightLayout = new javax.swing.GroupLayout(Flight);
        Flight.setLayout(FlightLayout);
        FlightLayout.setHorizontalGroup(
            FlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlightLayout.createSequentialGroup()
                        .addComponent(departureTime)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightLayout.createSequentialGroup()
                        .addComponent(departureLocation)
                        .addGap(18, 18, 18)
                        .addComponent(arrivalLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(airline))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(price)))
                .addContainerGap())
        );
        FlightLayout.setVerticalGroup(
            FlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departureLocation)
                        .addComponent(arrivalLocation))
                    .addComponent(airline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departureTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(price)
                .addContainerGap())
        );
        
        return Flight;
    }
    
    private static void FlightMouseClicked(java.awt.event.MouseEvent evt, javax.swing.JPanel frame, functionality.flight.Flight flight) {                                    
        frame.setBackground(new java.awt.Color(0, 255, 0));
        if (selectedFlightFrame != null) {
            selectedFlightFrame.setBackground(new java.awt.Color(153, 153, 255));
        }
        selectedFlightFrame = frame;
        selectedFlight = flight;
    }
    
    public functionality.flight.Flight getSelectedFlight() {
        return selectedFlight;
    }
}
