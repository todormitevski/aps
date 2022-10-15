package aud0;

public class Sarma {
    private int golemina;
    private boolean isVegetarian;
    private float tezina;

    public Sarma() {
    }

    public Sarma(int golemina, boolean isVegetarian, float tezina) {
        this.golemina = golemina;
        this.isVegetarian = isVegetarian;
        this.tezina = tezina;
    }

    public int getGolemina() {
        return golemina;
    }

    public void setGolemina(int golemina) {
        this.golemina = golemina;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public float getTezina() {
        return tezina;
    }

    public void setTezina(float tezina) {
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        return "Sarma{" +
                "golemina=" + golemina +
                ", isVegetarian=" + isVegetarian +
                ", tezina=" + tezina +
                '}';
    }
}
