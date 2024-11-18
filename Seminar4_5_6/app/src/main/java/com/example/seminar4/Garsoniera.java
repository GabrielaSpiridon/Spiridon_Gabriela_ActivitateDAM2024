package com.example.seminar4;

import android.os.Parcel;
import android.os.Parcelable;

public class Garsoniera implements Parcelable {

    String oras;
    String strada;
    int nrEtaj;
    int nrApartament;
    boolean esteOcupata;

    public Garsoniera() {
        this.oras = null;
        this.strada = null;
        this.nrEtaj = 0;
        this.nrApartament = 0;
        this.esteOcupata = false;
    }
    public Garsoniera(String oras, String strada, int nrEtaj, int nrApartament, boolean esteOcupata) {
        this.oras = oras;
        this.strada = strada;
        this.nrEtaj = nrEtaj;
        this.nrApartament = nrApartament;
        this.esteOcupata = esteOcupata;
    }

    protected Garsoniera(Parcel in) {
        oras = in.readString();
        strada = in.readString();
        nrEtaj = in.readInt();
        nrApartament = in.readInt();
        esteOcupata = in.readByte() != 0;
    }

    public static final Creator<Garsoniera> CREATOR = new Creator<Garsoniera>() {
        @Override
        public Garsoniera createFromParcel(Parcel in) {
            return new Garsoniera(in);
        }

        @Override
        public Garsoniera[] newArray(int size) {
            return new Garsoniera[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(oras);
        dest.writeString(strada);
        dest.writeInt(nrEtaj);
        dest.writeInt(nrApartament);
        dest.writeByte((byte) (esteOcupata ? 1 : 0));
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