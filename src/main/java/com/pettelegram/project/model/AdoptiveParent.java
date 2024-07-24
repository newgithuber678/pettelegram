package com.pettelegram.project.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "adoptive_parent")
public class AdoptiveParent {
    // список пока неполный
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String telegramNick;
    private int adoptionStatus;

    public AdoptiveParent() {
    }
    public AdoptiveParent(long id, String name, String surname, String telegramNick, int adoptionStatus) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelegramNick() {
        return telegramNick;
    }

    public void setTelegramNick(String telegramNick) {
        this.telegramNick = telegramNick;
    }

    public int getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(int adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdoptiveParent that = (AdoptiveParent) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AdoptiveParent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telegramNick='" + telegramNick + '\'' +
                ", adoptionStatus=" + adoptionStatus +
                '}';
    }
}
