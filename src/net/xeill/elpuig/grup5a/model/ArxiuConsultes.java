package net.xeill.elpuig.grup5a.model;

public class ArxiuConsultes {
    private String any;
    private String ambit;
    private String titularitat;
    private String latitud;
    private String longitud;
    private String tipusEquipament;
    private String equipament;
    private String districte;
    private String consultesPresencials;

    public ArxiuConsultes(String any, String ambit, String titularitat, String latitud, String longitud, String tipusEquipament, String equipament, String districte, String consultesPresencials) {
        this.any = any;
        this.ambit = ambit;
        this.titularitat = titularitat;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipusEquipament = tipusEquipament;
        this.equipament = equipament;
        this.districte = districte;
        this.consultesPresencials = consultesPresencials;
    }

    public ArxiuConsultes() {
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public String getAmbit() {
        return ambit;
    }

    public void setAmbit(String ambit) {
        this.ambit = ambit;
    }

    public String getTitularitat() {
        return titularitat;
    }

    public void setTitularitat(String titularitat) {
        this.titularitat = titularitat;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getTipusEquipament() {
        return tipusEquipament;
    }

    public void setTipusEquipament(String tipusEquipament) {
        this.tipusEquipament = tipusEquipament;
    }

    public String getEquipament() {
        return equipament;
    }

    public void setEquipament(String equipament) {
        this.equipament = equipament;
    }

    public String getDistricte() {
        return districte;
    }

    public void setDistricte(String districte) {
        this.districte = districte;
    }

    public String getConsultesPresencials() {
        return consultesPresencials;
    }

    public void setConsultesPresencials(String consultesPresencials) {
        this.consultesPresencials = consultesPresencials;
    }
}
