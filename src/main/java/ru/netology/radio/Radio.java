package ru.netology.radio;

public class Radio {
    private int currentRadioStation;
    private int currentVolume;
    private int minRadioStation;
    private int maxRadioStation;
    private int minVolume;
    private int maxVolume;


    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {

        if (currentRadioStation > 9) {
            currentRadioStation = 0;
        }

        if (currentRadioStation < 0) {
            currentRadioStation = 9;
        }

        this.currentRadioStation = currentRadioStation;
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

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public void setMinRadioStation(int minRadioStation) {
        this.minRadioStation = minRadioStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public void setMaxRadioStation(int maxRadioStation) {
        this.maxRadioStation = maxRadioStation;
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

    }

    public void decreaseCurrentVolume() {

    }

    public void nextRadioStation() {

    }

    public void prevRadioStation() {

    }
}
