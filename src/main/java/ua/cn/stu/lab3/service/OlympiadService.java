package ua.cn.stu.lab3.service;

import java.util.List;
import java.util.Optional;

import ua.cn.stu.lab3.entity.Olympiad;

public interface OlympiadService {
    
    List<Olympiad> findAll();
    
    List<Olympiad> findAllOrderByYearDesc();
    
    Optional<Olympiad> findById(Long id);
    
    List<Olympiad> findByYear(Integer year);
    
    List<Olympiad> findBySeason(String season);
    
    Olympiad save(Olympiad olympiad);
    
    void deleteById(Long id);
}

