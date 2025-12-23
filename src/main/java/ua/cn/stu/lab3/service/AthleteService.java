package ua.cn.stu.lab3.service;

import java.util.List;
import java.util.Optional;

import ua.cn.stu.lab3.entity.Athlete;

public interface AthleteService {
    
    List<Athlete> findAll();
    
    Optional<Athlete> findById(Long id);
    
    List<Athlete> findBySportId(Long sportId);
    
    List<Athlete> findByCountry(String country);
    
    Athlete save(Athlete athlete);
    
    void deleteById(Long id);
}

