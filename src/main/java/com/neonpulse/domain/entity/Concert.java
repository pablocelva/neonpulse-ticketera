package com.neonpulse.domain.entity;

public class Concert {

  private final String id;
  private final String title;
  private final String band;
  private final double ticketPrice;
  
  public Concert(String id, String title, String band, double ticketPrice){
    if(id == null || id.isBlank()){
      throw new IllegalArgumentException("El ID es obligatorio.");
    }
    if(ticketPrice < 0){
      throw new IllegalArgumentException("El precio del ticket no puede ser negativo.");
    }

    this.id = id;
    this.title = title;
    this.band = band;
    this.ticketPrice = ticketPrice;
  }

  // GETTER
  public String getId() { return id; }
  public String getTitle() { return title; }
  public String getBand() { return band; }
  public double getTicketPrice() { return ticketPrice; }
}