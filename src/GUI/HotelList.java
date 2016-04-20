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
public class HotelList {
    private static functionality.hotel.Hotel selectedHotel;
    private static javax.swing.JPanel selectedHotelFrame;
    
    // Returns a JPanel with the hotel results from hotels
    public static javax.swing.JPanel displayHotels(functionality.hotel.Hotel[] hotels, javax.swing.JPanel container) {
        selectedHotel = null;
        selectedHotelFrame = null;
        
        javax.swing.JPanel[] hotelPanels = new javax.swing.JPanel[hotels.length];
        for (int i=0;i<hotels.length;i++) {
            hotelPanels[i] = createTicket(hotels[i]);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(container);
        container.setLayout(layout);
            
        javax.swing.GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        for (JComponent hotelPanel : hotelPanels) {
            horizontalGroup.addComponent(hotelPanel);
        }
        layout.setHorizontalGroup(horizontalGroup);
        javax.swing.GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addContainerGap();
        for (JComponent hotelPanel : hotelPanels) {
            verticalGroup.addComponent(hotelPanel);
            verticalGroup.addGap(0, 10, Short.MAX_VALUE);
        }
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addGroup(verticalGroup));
        
        return container;
    }
    
    // Creates a ticket with information about hotel h
    private static javax.swing.JPanel createTicket(functionality.hotel.Hotel h) {
        javax.swing.JPanel Hotel = new javax.swing.JPanel();
        javax.swing.JLabel Name = new javax.swing.JLabel();
        javax.swing.JLabel Type = new javax.swing.JLabel();
        javax.swing.JLabel Location = new javax.swing.JLabel();
        javax.swing.JLabel Price = new javax.swing.JLabel();

        Hotel.setBackground(new java.awt.Color(153, 153, 255));
        Hotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HotelMouseClicked(evt, Hotel, h);
            }
        });

        Name.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        Name.setText(h.getName());

        Type.setText(h.getType());

        Location.setText(h.getLocation());

        Price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        Price.setText(String.valueOf(h.getPrice()));

        javax.swing.GroupLayout HotelLayout = new javax.swing.GroupLayout(Hotel);
        Hotel.setLayout(HotelLayout);
        HotelLayout.setHorizontalGroup(
            HotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HotelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HotelLayout.createSequentialGroup()
                        .addComponent(Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(Type))
                    .addGroup(HotelLayout.createSequentialGroup()
                        .addComponent(Location)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HotelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Price)))
                .addContainerGap())
        );
        HotelLayout.setVerticalGroup(
            HotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HotelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(Type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Location)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(Price)
                .addContainerGap())
        );
        
        return Hotel;
    }
    
    private static void HotelMouseClicked(java.awt.event.MouseEvent evt, javax.swing.JPanel frame, functionality.hotel.Hotel hotel) {                                    
        frame.setBackground(new java.awt.Color(0, 255, 0));
        if (selectedHotelFrame != null) {
            selectedHotelFrame.setBackground(new java.awt.Color(153, 153, 255));
        }
        selectedHotelFrame = frame;
        selectedHotel = hotel;
    }
    
    public functionality.hotel.Hotel getSelectedHotel() {
        return selectedHotel;
    }
}
