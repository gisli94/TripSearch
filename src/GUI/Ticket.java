/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author skulii
 */
public class Ticket {
    public static javax.swing.JPanel createTicket(javax.swing.JPanel container, other.UserInfo user, functionality.flight.Flight flightOut, functionality.flight.Flight flightHome, functionality.hotel.Hotel hotel, functionality.daytours.Trip tour) {
        javax.swing.JPanel Ticket = new javax.swing.JPanel();
        javax.swing.JLabel Instruction = new javax.swing.JLabel();
        javax.swing.JLabel FlightOut = new javax.swing.JLabel();
        javax.swing.JLabel FlightHome = new javax.swing.JLabel();
        javax.swing.JLabel Hotel = new javax.swing.JLabel();
        javax.swing.JLabel Tour = new javax.swing.JLabel();

        Instruction.setText("Dear " + user.getName() + ", you are about the book the following items: ");

        FlightOut.setText(flightOut.getDeparture() + " to " + flightOut.getArrival() + " - " + flightOut.getDateAndTime() + " - " + flightOut.getCompany() + " - " + flightOut.getStartPrice() + " ISK");
        
        FlightHome.setText(flightHome.getDeparture() + " to " + flightHome.getArrival() + " - " + flightHome.getDateAndTime() + " - " + flightHome.getCompany() + " - " + flightHome.getStartPrice() + " ISK");

        Hotel.setText(hotel.getName() + " - " + hotel.getLocation());
        
        Tour.setText(tour.getType() + " - " + tour.getDate() + " - " + tour.getLocation());

        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Instruction)
                    .addComponent(FlightOut)
                    .addComponent(FlightHome)
                    .addComponent(Hotel)
                    .addComponent(Tour))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Instruction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FlightOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FlightHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hotel)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(container);
        container.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 181, Short.MAX_VALUE))
        );
        
        return container;
    }
}
