package aud0;

public class TV {
    private String proizvoditel;
    private int ekran;
    private boolean isSmart;

    public TV() {
    }

    public TV(String proizvoditel, int ekran, boolean isSmart) {
        this.proizvoditel = proizvoditel;
        this.ekran = ekran;
        this.isSmart = isSmart;
    }

    public String getProizvoditel() {
        return proizvoditel;
    }

    public void setProizvoditel(String proizvoditel) {
        this.proizvoditel = proizvoditel;
    }

    public int getEkran() {
        return ekran;
    }

    public void setEkran(int ekran) {
        this.ekran = ekran;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    @Override
    public String toString() {
        return "TV{" +
                "proizvoditel='" + proizvoditel + '\'' +
                ", ekran=" + ekran +
                ", isSmart=" + isSmart +
                '}';
    }
}
