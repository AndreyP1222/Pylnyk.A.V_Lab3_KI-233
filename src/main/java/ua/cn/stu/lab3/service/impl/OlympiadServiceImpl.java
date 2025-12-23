package ua.cn.stu.lab3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.cn.stu.lab3.entity.Olympiad;
import ua.cn.stu.lab3.repository.OlympiadRepository;
import ua.cn.stu.lab3.service.OlympiadService;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class OlympiadServiceImpl implements OlympiadService {

    private final OlympiadRepository olympiadRepository;

    @Override
    public List<Olympiad> findAll() {
        return olympiadRepository.findAll();
    }

    @Override
    public List<Olympiad> findAllOrderByYearDesc() {
        return olympiadRepository.findAllByOrderByYearDesc();
    }

    @Override
    public Optional<Olympiad> findById(Long id) {
        return olympiadRepository.findById(id);
    }

    @Override
    public List<Olympiad> findByYear(Integer year) {
        return olympiadRepository.findByYear(year);
    }

    @Override
    public List<Olympiad> findBySeason(String season) {
        return olympiadRepository.findBySeason(season);
    }

    @Override
    @Transactional
    public Olympiad save(Olympiad olympiad) {
        log.info("Saving olympiad: {} {}", olympiad.getName(), olympiad.getYear());
        return olympiadRepository.save(olympiad);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting olympiad with id: {}", id);
        olympiadRepository.deleteById(id);
    }
}

