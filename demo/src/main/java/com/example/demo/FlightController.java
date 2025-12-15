package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired private AirportRepository airportRepo;
    @Autowired private FlightRepository flightRepo;
    @Autowired private SeatRepository seatRepo;
    @Autowired private CustomerRepository customerRepo;

    private void handleDbError(Exception e) {
        if (e instanceof DataIntegrityViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                "Database Error: Required field missing or invalid Foreign Key (e.g., Airport/Flight does not exist).");
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports() { return airportRepo.findAll(); }

    @PostMapping("/airports")
    public Airport addAirport(@RequestBody Airport a) {
        try { return airportRepo.save(a); } catch (Exception e) { handleDbError(e); return null; }
    }

    @PutMapping("/airports/{id}")
    public Airport updateAirport(@PathVariable String id, @RequestBody Airport a) {
        if(!airportRepo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport not found");
        a.setAirportCode(id);
        try { return airportRepo.save(a); } catch (Exception e) { handleDbError(e); return null; }
    }

    @DeleteMapping("/airports/{id}")
    public void deleteAirport(@PathVariable String id) {
        try { airportRepo.deleteById(id); } catch (Exception e) { handleDbError(e); }
    }

    @GetMapping("/flights")
    public List<Flight> getFlights(@RequestParam(required = false) String origin) {
        if (origin != null) return flightRepo.findByOriginCode(origin);
        return flightRepo.findAll();
    }

    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight f) {
        try { return flightRepo.save(f); } catch (Exception e) { handleDbError(e); return null; }
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight f) {
        if(!flightRepo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        f.setFlightId(id);
        try { return flightRepo.save(f); } catch (Exception e) { handleDbError(e); return null; }
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable Integer id) {
        try { flightRepo.deleteById(id); } catch (Exception e) { handleDbError(e); }
    }

    @GetMapping("/seats")
    public List<Seat> getSeats(@RequestParam(required = false) Integer flightId) {
        if (flightId != null) return seatRepo.findByFlightId(flightId);
        return seatRepo.findAll();
    }

    @PostMapping("/seats")
    public Seat addSeat(@RequestBody Seat s) {
        try { return seatRepo.save(s); } catch (Exception e) { handleDbError(e); return null; }
    }

    @PutMapping("/seats/{id}")
    public Seat updateSeat(@PathVariable Integer id, @RequestBody Seat s) {
        Seat existing = seatRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
        if(s.getSeatNumber() != null) existing.setSeatNumber(s.getSeatNumber());
        if(s.getClassType() != null) existing.setClassType(s.getClassType());
        if(s.getCustomerId() != null) existing.setCustomerId(s.getCustomerId() == 0 ? null : s.getCustomerId()); // 0 clears the seat
        
        try { return seatRepo.save(existing); } catch (Exception e) { handleDbError(e); return null; }
    }

    @DeleteMapping("/seats/{id}")
    public void deleteSeat(@PathVariable Integer id) {
        try { seatRepo.deleteById(id); } catch (Exception e) { handleDbError(e); }
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() { return customerRepo.findAll(); }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return customerRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer c) {
        try { return customerRepo.save(c); } catch (Exception e) { handleDbError(e); return null; }
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer c) {
        if(!customerRepo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        c.setCustomerId(id);
        try { return customerRepo.save(c); } catch (Exception e) { handleDbError(e); return null; }
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        try { customerRepo.deleteById(id); } catch (Exception e) { handleDbError(e); }
    }
}