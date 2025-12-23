package ua.cn.stu.lab3.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "athletes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private Integer goldMedals = 0;

    @Column(nullable = false)
    private Integer silverMedals = 0;

    @Column(nullable = false)
    private Integer bronzeMedals = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(Integer goldMedals) {
        this.goldMedals = goldMedals;
    }

    public Integer getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(Integer silverMedals) {
        this.silverMedals = silverMedals;
    }

    public Integer getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(Integer bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getTotalMedals() {
        return goldMedals + silverMedals + bronzeMedals;
    }
}

