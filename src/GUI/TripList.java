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
public class TripList {
    
    private static functionality.Trip selectedTrip;
    private static javax.swing.JPanel selectedTripFrame;
    
    // Returns a JPanel with the trip results from trips
    public static javax.swing.JPanel displayTrips(functionality.Trip[] trips, javax.swing.JPanel container) {
        selectedTripFrame = null;
        
        javax.swing.JPanel[] tripPanels = new javax.swing.JPanel[trips.length];
        for (int i=0;i<trips.length;i++) {
            tripPanels[i] = createTicket(trips[i]);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(container);
        container.setLayout(layout);
            
        javax.swing.GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        for (JComponent tripPanel : tripPanels) {
            horizontalGroup.addComponent(tripPanel);
        }
        layout.setHorizontalGroup(horizontalGroup);
        javax.swing.GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addContainerGap();
        for (JComponent tripPanel : tripPanels) {
            verticalGroup.addComponent(tripPanel);
            verticalGroup.addGap(0, 10, Short.MAX_VALUE);
        }
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addGroup(verticalGroup));
        
        return container;
    }
    
    // Creates a ticket with information about hotel h
    private static javax.swing.JPanel createTicket(functionality.Trip t) {
        javax.swing.JPanel Trip = new javax.swing.JPanel();
        javax.swing.JLabel type = new javax.swing.JLabel();
        javax.swing.JLabel duration = new javax.swing.JLabel();
        javax.swing.JLabel date = new javax.swing.JLabel();
        javax.swing.JLabel location = new javax.swing.JLabel();
        javax.swing.JLabel price = new javax.swing.JLabel();

        Trip.setBackground(new java.awt.Color(153, 153, 255));
        Trip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TripMouseClicked(evt, Trip, t);
            }
        });

        type.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        type.setText(t.getType());

        duration.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        duration.setText(t.getDuration());

        date.setText(t.getDate().toString());

        location.setText(t.getLocation());

        price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        price.setText(String.valueOf(t.getPrice()));

        javax.swing.GroupLayout TripLayout = new javax.swing.GroupLayout(Trip);
        Trip.setLayout(TripLayout);
        TripLayout.setHorizontalGroup(
            TripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TripLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TripLayout.createSequentialGroup()
                        .addComponent(date)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TripLayout.createSequentialGroup()
                        .addComponent(type)
                        .addGap(18, 18, 18)
                        .addComponent(duration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(location))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TripLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(price)))
                .addContainerGap())
        );
        TripLayout.setVerticalGroup(
            TripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TripLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(type)
                        .addComponent(duration))
                    .addComponent(location))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(price)
                .addContainerGap())
        );
        
        return Trip;
    }
    
    private static void TripMouseClicked(java.awt.event.MouseEvent evt, javax.swing.JPanel frame, functionality.Trip trip) {                                    
        frame.setBackground(new java.awt.Color(0, 255, 0));
        if (selectedTripFrame != null) {
            selectedTripFrame.setBackground(new java.awt.Color(153, 153, 255));
        }
        selectedTripFrame = frame;
        selectedTrip = trip;
    }   
}

