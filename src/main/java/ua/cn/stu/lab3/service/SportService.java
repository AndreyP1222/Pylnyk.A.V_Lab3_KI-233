package ua.cn.stu.lab3.service;

import java.util.List;
import java.util.Optional;

import ua.cn.stu.lab3.entity.Sport;

public interface SportService {
    
    List<Sport> findAll();
    
    Optional<Sport> findById(Long id);
    
    List<Sport> findByOlympiadId(Long olympiadId);
    
    List<Sport> findByCategory(String category);
    
    Sport save(Sport sport);
    
    void deleteById(Long id);
}

