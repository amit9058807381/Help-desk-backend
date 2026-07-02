package com.spring.helpDesk.Help_desk_backend.service;


import com.spring.helpDesk.Help_desk_backend.entity.Ticket;
import com.spring.helpDesk.Help_desk_backend.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private Logger log = LoggerFactory.getLogger(TicketService.class);

    private final TicketRepository ticketRepository;

    //create ticket

    @Transactional
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(null);
        this.log.info("Creating a new ticket with id " + ticket.getId());
        return ticketRepository.save(ticket);
    }

    //update ticket

    @Transactional
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // get ticket logic
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }


    //get ticket by username
    public Ticket getTicketByEmailId(String email) {
        return ticketRepository.findByEmail(email).orElse(null);
    }

}
