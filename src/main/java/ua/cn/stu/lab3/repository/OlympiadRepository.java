package ua.cn.stu.lab3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.cn.stu.lab3.entity.Olympiad;

@Repository
public interface OlympiadRepository extends JpaRepository<Olympiad, Long> {
    
    List<Olympiad> findByYear(Integer year);
    
    List<Olympiad> findBySeason(String season);
    
    List<Olympiad> findByCountry(String country);
    
    List<Olympiad> findAllByOrderByYearDesc();
}

