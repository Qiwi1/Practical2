package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PostTwo {
    public PostTwo(String nazvanie, String strana, String ves, String forma, String kolwo) {
        this.nazvanie = nazvanie;
        this.strana = strana;
        this.ves = ves;
        this.forma = forma;
        this.kolwo = kolwo;
    }

    public PostTwo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazvanie,  strana,  ves,  forma,  kolwo;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }

    public String getVes() {
        return ves;
    }

    public void setVes(String ves) {
        this.ves = ves;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getKolwo() {
        return kolwo;
    }

    public void setKolwo(String kolwo) {
        this.kolwo = kolwo;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
