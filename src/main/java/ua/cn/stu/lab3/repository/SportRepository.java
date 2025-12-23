package ua.cn.stu.lab3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.cn.stu.lab3.entity.Olympiad;
import ua.cn.stu.lab3.entity.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
    
    List<Sport> findByOlympiad(Olympiad olympiad);
    
    List<Sport> findByOlympiadId(Long olympiadId);
    
    List<Sport> findByCategory(String category);
    
    List<Sport> findByNameContainingIgnoreCase(String name);
}

