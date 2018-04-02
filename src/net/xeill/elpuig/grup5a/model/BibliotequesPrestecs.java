package net.xeill.elpuig.grup5a.model;

public class BibliotequesPrestecs {
    private String any;
    private String ambit;
    private String titularitat;
    private String latitud;
    private String longitud;
    private String tipusEquipament;
    private String equipament;
    private String districte;
    private String prestecs;
    private String nota;

    public BibliotequesPrestecs(String any, String ambit, String titularitat, String latitud, String longitud, String tipusEquipament, String equipament, String districte, String prestecs, String nota) {
        this.any = any;
        this.ambit = ambit;
        this.titularitat = titularitat;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipusEquipament = tipusEquipament;
        this.equipament = equipament;
        this.districte = districte;
        this.prestecs = prestecs;
        this.nota=nota;
    }

    public BibliotequesPrestecs() {
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

    public String getPrestecs() {
        return prestecs;
    }

    public void setPrestecs(String prestecs) {
        this.prestecs = prestecs;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}