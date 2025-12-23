package ua.cn.stu.lab3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.cn.stu.lab3.entity.Athlete;
import ua.cn.stu.lab3.entity.Sport;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    
    List<Athlete> findBySport(Sport sport);
    
    List<Athlete> findBySportId(Long sportId);
    
    List<Athlete> findByCountry(String country);
    
    List<Athlete> findByLastNameContainingIgnoreCase(String lastName);
    
    List<Athlete> findByGoldMedalsGreaterThan(Integer count);
}

