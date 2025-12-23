package ua.cn.stu.lab3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.cn.stu.lab3.entity.Sport;
import ua.cn.stu.lab3.repository.SportRepository;
import ua.cn.stu.lab3.service.SportService;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    @Override
    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    @Override
    public Optional<Sport> findById(Long id) {
        return sportRepository.findById(id);
    }

    @Override
    public List<Sport> findByOlympiadId(Long olympiadId) {
        return sportRepository.findByOlympiadId(olympiadId);
    }

    @Override
    public List<Sport> findByCategory(String category) {
        return sportRepository.findByCategory(category);
    }

    @Override
    @Transactional
    public Sport save(Sport sport) {
        log.info("Saving sport: {}", sport.getName());
        return sportRepository.save(sport);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting sport with id: {}", id);
        sportRepository.deleteById(id);
    }
}

