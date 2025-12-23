package ua.cn.stu.lab3.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.cn.stu.lab3.entity.Athlete;
import ua.cn.stu.lab3.entity.Olympiad;
import ua.cn.stu.lab3.entity.Sport;
import ua.cn.stu.lab3.repository.AthleteRepository;
import ua.cn.stu.lab3.repository.OlympiadRepository;
import ua.cn.stu.lab3.repository.SportRepository;

@Component
@Profile("!test")
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OlympiadRepository olympiadRepository;
    private final SportRepository sportRepository;
    private final AthleteRepository athleteRepository;

    @Override
    @Transactional
    public void run(String... args) {
        initBusinessData();
    }

    private void initBusinessData() {
        if (olympiadRepository.count() > 0) {
            log.info("Business data already exists - skipping initialization.");
            return;
        }

        log.info("Loading IOC (МОК) business data...");

        // Олімпіади
        Olympiad tokyo2020 = new Olympiad();
        tokyo2020.setName("Олімпійські ігри 2020");
        tokyo2020.setYear(2020);
        tokyo2020.setCity("Токіо");
        tokyo2020.setCountry("Японія");
        tokyo2020.setSeason("Літні");
        olympiadRepository.save(tokyo2020);

        Olympiad paris2024 = new Olympiad();
        paris2024.setName("Олімпійські ігри 2024");
        paris2024.setYear(2024);
        paris2024.setCity("Париж");
        paris2024.setCountry("Франція");
        paris2024.setSeason("Літні");
        olympiadRepository.save(paris2024);

        Olympiad beijing2022 = new Olympiad();
        beijing2022.setName("Зимові Олімпійські ігри 2022");
        beijing2022.setYear(2022);
        beijing2022.setCity("Пекін");
        beijing2022.setCountry("Китай");
        beijing2022.setSeason("Зимові");
        olympiadRepository.save(beijing2022);

        // Види спорту для Токіо 2020
        Sport swimming = new Sport();
        swimming.setName("Плавання");
        swimming.setCategory("Водні види спорту");
        swimming.setMedalsCount(35);
        swimming.setOlympiad(tokyo2020);
        sportRepository.save(swimming);

        Sport athletics = new Sport();
        athletics.setName("Легка атлетика");
        athletics.setCategory("Індивідуальний");
        athletics.setMedalsCount(48);
        athletics.setOlympiad(tokyo2020);
        sportRepository.save(athletics);

        Sport gymnastics = new Sport();
        gymnastics.setName("Спортивна гімнастика");
        gymnastics.setCategory("Індивідуальний");
        gymnastics.setMedalsCount(14);
        gymnastics.setOlympiad(tokyo2020);
        sportRepository.save(gymnastics);

        // Види спорту для Парижа 2024
        Sport football = new Sport();
        football.setName("Футбол");
        football.setCategory("Командний");
        football.setMedalsCount(2);
        football.setOlympiad(paris2024);
        sportRepository.save(football);

        Sport fencing = new Sport();
        fencing.setName("Фехтування");
        fencing.setCategory("Індивідуальний");
        fencing.setMedalsCount(12);
        fencing.setOlympiad(paris2024);
        sportRepository.save(fencing);

        // Види спорту для Пекіна 2022
        Sport skiing = new Sport();
        skiing.setName("Гірськолижний спорт");
        skiing.setCategory("Зимовий");
        skiing.setMedalsCount(11);
        skiing.setOlympiad(beijing2022);
        sportRepository.save(skiing);

        Sport biathlon = new Sport();
        biathlon.setName("Біатлон");
        biathlon.setCategory("Зимовий");
        biathlon.setMedalsCount(11);
        biathlon.setOlympiad(beijing2022);
        sportRepository.save(biathlon);

        // Спортсмени для плавання
        Athlete dressel = new Athlete();
        dressel.setFirstName("Калеб");
        dressel.setLastName("Дрессел");
        dressel.setCountry("США");
        dressel.setBirthDate(LocalDate.of(1996, 8, 16));
        dressel.setGoldMedals(5);
        dressel.setSilverMedals(0);
        dressel.setBronzeMedals(0);
        dressel.setSport(swimming);
        athleteRepository.save(dressel);

        Athlete ledecky = new Athlete();
        ledecky.setFirstName("Кеті");
        ledecky.setLastName("Ледекі");
        ledecky.setCountry("США");
        ledecky.setBirthDate(LocalDate.of(1997, 3, 17));
        ledecky.setGoldMedals(2);
        ledecky.setSilverMedals(2);
        ledecky.setBronzeMedals(0);
        ledecky.setSport(swimming);
        athleteRepository.save(ledecky);

        // Спортсмени для легкої атлетики
        Athlete bolt = new Athlete();
        bolt.setFirstName("Усейн");
        bolt.setLastName("Болт");
        bolt.setCountry("Ямайка");
        bolt.setBirthDate(LocalDate.of(1986, 8, 21));
        bolt.setGoldMedals(8);
        bolt.setSilverMedals(0);
        bolt.setBronzeMedals(0);
        bolt.setSport(athletics);
        athleteRepository.save(bolt);

        Athlete thompson = new Athlete();
        thompson.setFirstName("Елейн");
        thompson.setLastName("Томпсон-Гера");
        thompson.setCountry("Ямайка");
        thompson.setBirthDate(LocalDate.of(1992, 6, 28));
        thompson.setGoldMedals(3);
        thompson.setSilverMedals(1);
        thompson.setBronzeMedals(0);
        thompson.setSport(athletics);
        athleteRepository.save(thompson);

        // Спортсмени для гімнастики
        Athlete biles = new Athlete();
        biles.setFirstName("Сімоне");
        biles.setLastName("Байлз");
        biles.setCountry("США");
        biles.setBirthDate(LocalDate.of(1997, 3, 14));
        biles.setGoldMedals(4);
        biles.setSilverMedals(1);
        biles.setBronzeMedals(2);
        biles.setSport(gymnastics);
        athleteRepository.save(biles);

        // Спортсмени для біатлону
        Athlete fourcade = new Athlete();
        fourcade.setFirstName("Мартен");
        fourcade.setLastName("Фуркад");
        fourcade.setCountry("Франція");
        fourcade.setBirthDate(LocalDate.of(1988, 9, 14));
        fourcade.setGoldMedals(5);
        fourcade.setSilverMedals(2);
        fourcade.setBronzeMedals(0);
        fourcade.setSport(biathlon);
        athleteRepository.save(fourcade);

        Athlete boe = new Athlete();
        boe.setFirstName("Йоганнес");
        boe.setLastName("Бьо");
        boe.setCountry("Норвегія");
        boe.setBirthDate(LocalDate.of(1993, 5, 16));
        boe.setGoldMedals(4);
        boe.setSilverMedals(1);
        boe.setBronzeMedals(1);
        boe.setSport(biathlon);
        athleteRepository.save(boe);

        // Спортсмени для гірськолижного спорту
        Athlete shiffrin = new Athlete();
        shiffrin.setFirstName("Мікаела");
        shiffrin.setLastName("Шиффрін");
        shiffrin.setCountry("США");
        shiffrin.setBirthDate(LocalDate.of(1995, 3, 13));
        shiffrin.setGoldMedals(2);
        shiffrin.setSilverMedals(1);
        shiffrin.setBronzeMedals(0);
        shiffrin.setSport(skiing);
        athleteRepository.save(shiffrin);

        log.info("IOC (МОК) business data loaded successfully!");
    }
}

