package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int minStation;
    private int maxStation;
    private int minVolume;
    private int maxVolume;


    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {

        if (currentStation > maxStation) {
            currentStation = currentStation - maxStation - 1;
        }

        if (currentStation < minStation) {
            currentStation = maxStation + currentStation;
        }

        this.currentStation = currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {

        if (currentVolume > maxVolume || currentVolume < minVolume) {
            return;
        }

        this.currentVolume = currentVolume;
    }

    public int getMinStation() {
        return minStation;
    }

    public void setMinStation(int minStation) {
        this.minStation = minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setMaxStation(int maxStation) {
        this.maxStation = maxStation;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void increaseCurrentVolume() {

        int incVolume = getCurrentVolume() + 1;
        setCurrentVolume(incVolume);

    }

    public void decreaseCurrentVolume() {

        int decVolume = getCurrentVolume() - 1;
        setCurrentVolume(decVolume);

    }

    public void nextStation() {

        int nextStation = getCurrentStation() + 1;
        setCurrentStation(nextStation);

    }

    public void prevStation() {

        int prevStation = getCurrentStation() - 1;
        setCurrentStation(prevStation);
    }
}
