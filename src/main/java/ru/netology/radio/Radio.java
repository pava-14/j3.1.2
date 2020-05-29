package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int minStation = 0;
    private final int maxStation = 9;
    private final int minVolume = 0;
    private final int maxVolume = 10;

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

    public int getMaxStation() {
        return maxStation;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
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
