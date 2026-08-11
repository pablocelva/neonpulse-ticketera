package com.neonpulse.application.usecase;

import com.neonpulse.domain.entity.Concert;
import com.neonpulse.domain.repository.ConcertRepository;

public class RegisterConcertUseCase {
  private final ConcertRepository concertRepository;

  // inyeccion de dependecias por constructor
  public RegisterConcertUseCase(ConcertRepository concertRepository) {
    this.concertRepository = concertRepository;
  }

  public void execute(Concert concert){
    // Regla de negocio: validar que no exista el ID en la base de datos
    if(concertRepository.findById(concert.getId()).isPresent()){
      throw new IllegalArgumentException("El ID del concierto ya existe.");
    }
    
    // Guardar a traves de la "frontera abstracta"
    concertRepository.save(concert);
  }

}