package com.farid.lespoints;


public class ItemObject {
    public String resto;
    public String services;
    public String adresse;
    public String horaires;
    public String tel;
    public String description;
    public String img;

    public ItemObject(String resto, String services, String adresse, String horaires,
                      String tel, String description, String img) {
        this.resto = resto;
        this.services = services;
        this.adresse = adresse;
        this.horaires = horaires;
        this.tel = tel;
        this.description = description;
        this.img = img;
    }

    public String getResto() {
        return resto;
    }

    public String getServices() {
        return services;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getHoraires() {
        return horaires;
    }

    public String getTel() {
        return tel;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }
}
