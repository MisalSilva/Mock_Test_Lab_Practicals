package core;
import logging.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class TicketPool implements TicketOperation {
    private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());
    @Override
    public synchronized void addTickets(String ticket) {
        tickets.add(ticket);
        Logger.logTicketOperation("add", ticket);
    }
    @Override
    public synchronized String removeTicket() {
        return tickets.isEmpty() ? null : tickets.remove(0);
        if (!tickets.isEmpty()){
            String ticket=tickets.remove(0);
            Logger.logTicketOperation(ticket,"remove");
            return ticket;
        }
        else{
            Logger.log("No tickets available to remove");
            return null;
        }
    }
    public int getTicketCount() {
        return tickets.size();
    }
}