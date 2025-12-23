package ua.cn.stu.lab3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.cn.stu.lab3.entity.Athlete;
import ua.cn.stu.lab3.repository.AthleteRepository;
import ua.cn.stu.lab3.service.AthleteService;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AthleteServiceImpl implements AthleteService {

    private final AthleteRepository athleteRepository;

    @Override
    public List<Athlete> findAll() {
        return athleteRepository.findAll();
    }

    @Override
    public Optional<Athlete> findById(Long id) {
        return athleteRepository.findById(id);
    }

    @Override
    public List<Athlete> findBySportId(Long sportId) {
        return athleteRepository.findBySportId(sportId);
    }

    @Override
    public List<Athlete> findByCountry(String country) {
        return athleteRepository.findByCountry(country);
    }

    @Override
    @Transactional
    public Athlete save(Athlete athlete) {
        log.info("Saving athlete: {} {}", athlete.getFirstName(), athlete.getLastName());
        return athleteRepository.save(athlete);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting athlete with id: {}", id);
        athleteRepository.deleteById(id);
    }
}

