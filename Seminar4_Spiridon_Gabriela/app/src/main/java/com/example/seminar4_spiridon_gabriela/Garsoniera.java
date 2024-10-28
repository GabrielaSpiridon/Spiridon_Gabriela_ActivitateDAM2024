package com.example.seminar4_spiridon_gabriela;

public class Garsoniera {

    String oras;

    String strada;

    int nrEtaj;
    int nrApartament;
    boolean esteOcupata;

    public Garsoniera(String oras,String strada, int nrEtaj, int nrApartament, boolean esteOcupata) {
        this.oras = oras;
        this.strada = strada;
        this.nrEtaj = nrEtaj;
        this.nrApartament = nrApartament;
        this.esteOcupata = esteOcupata;
    }

    public Garsoniera() {
        this.oras = null;
        this.strada = null;
        this.nrEtaj = 0;
        this.nrApartament = 0;
        this.esteOcupata = false;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setNrEtaj(int nrEtaj) {
        this.nrEtaj = nrEtaj;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    public void setEsteOcupata(boolean esteOcupata) {
        this.esteOcupata = esteOcupata;
    }

    public String getStrada() {
        return strada;
    }

    public int getNrEtaj() {
        return nrEtaj;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public boolean getEsteOcupata() {
        return esteOcupata;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Garsoniera: {");
        sb.append("oras: ").append(oras).append('\'');
        sb.append(", strada: ").append(strada).append('\'');
        sb.append(", numar etaj: ").append(nrEtaj).append('\'');
        sb.append(", numar apartament: ").append(nrApartament).append('\'');
        sb.append(", este ocupata: ").append(esteOcupata).append('\'');
        sb.append('}');
        return sb.toString();

    }
}
