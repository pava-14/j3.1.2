package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldInvalidMaxSetCurrentVolume() {
        Radio radio = new Radio(1, 2);
        //int currentStation, int currentVolume, int minStation, int maxStation, int minVolume, int maxVolume
        // Запомнить текущую громкость
        int expected = radio.getCurrentVolume();
        // Установить значение громкости больше максимальной
        radio.setCurrentVolume(11);
        // Проверить, что текущая громкость не изменилась
        assertEquals(expected, radio.getCurrentVolume());
    }

    @Test
    void shouldInvalidMinSetCurrentVolume() {
        Radio radio = new Radio(1, 2);
        // Запомнить текущую громкость
        int expected = radio.getCurrentVolume();
        // Установить значение громкости больше максимальной
        radio.setCurrentVolume(-1);
        // Проверить, что текущая громкость не изменилась
        assertEquals(expected, radio.getCurrentVolume());
    }

    @Test
    void shouldIncreaseCurrentVolume() {
        Radio radio = new Radio(1, 2, 0, 9, 0, 10);
        // Установить текущую громкость
        radio.setCurrentVolume(9);
        // Нажимать кнопку увеличения громкости 2 раза
        radio.increaseCurrentVolume();
        radio.increaseCurrentVolume();
        // Проверить, что громкость равна максимально возможной
        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseCurrentVolume() {
        Radio radio = new Radio(1, 2, 0, 9, 0, 10);
        // Установить текущую громкость
        radio.setCurrentVolume(1);
        // Нажимать кнопку уменьшения громкости 2 раза
        radio.decreaseCurrentVolume();
        radio.decreaseCurrentVolume();
        // Проверить, что громкость равна минимально возможной
        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldSetCurrentStation() {
        Radio radio = new Radio(1, 2, 0, 9, 0, 10);
        int expected = 5;
        // Установить станцию 5
        radio.setCurrentStation(expected);
        // Проверить, что станция 5 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldInvalidMinSetCurrentStation() {
        Radio radio = new Radio(1, 2);
        int expected = radio.getCurrentStation();
        // Установить станцию меньше минимальной
        radio.setCurrentStation(-1);
        // Проверить, что текущая станция не изменилась
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldInvalidMaxSetCurrentStation() {
        Radio radio = new Radio(1, 2);
        int expected = radio.getCurrentStation();
        // Установить станцию больше максимальной
        radio.setCurrentStation(10);
        // Проверить, что текущая станция не изменилась
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldNextRadioStation() {
        Radio radio = new Radio(1, 2, 0, 9, 0, 10);
        // Установить станцию 8
        radio.setCurrentStation(8);
        // Нажать 2 раза next
        radio.nextStation();
        radio.nextStation();
        // Ожидаемый результат
        int expected = 0;
        // Проверить, что станция 0 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldPrevRadioStation() {
        Radio radio = new Radio(1, 2, 0, 9, 0, 10);
        // Установить станцию 1
        radio.setCurrentStation(1);
        // Нажать 2 раза prev
        radio.prevStation();
        radio.prevStation();
        // Ожидаемый результат
        int expected = 9;
        // Проверить, что станция 9 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }
}