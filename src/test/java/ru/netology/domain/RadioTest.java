package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    void selectRandomStation(Radio radio) {

        Random random = new Random();
        // Выбираем случайную станцию из диапазона 0..10
        radio.setCurrentStation(random.nextInt(10));
    }

    @Test
    void shouldSetCurrentStation() {

        Radio radio = new Radio();

        Random random = new Random();

        // Клиент должен иметь возможность выставлять номер
        // радиостанции с цифрового пульта (вводя числа 0 - 9)
        int expected = random.nextInt(10);

        radio.setCurrentStation(expected);

        assertEquals(expected, radio.getCurrentStation());

    }

    @ParameterizedTest
    @CsvSource({"14"})
    void shouldIncreaseCurrentVolume(int countClick) {

        Radio radio = new Radio();

        // Нажимаем кнопку увеличения громкости
        for (int i = 0; i < countClick; i++) {
            radio.increaseCurrentVolume();
        }

        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"20"})
    void shouldDecreaseCurrentVolume(int countClick) {

        Radio radio = new Radio();

        // Нажимаем 20 раз кнопку уменьшения громкости
        for (int i = 0; i < countClick; i++) {
            radio.decreaseCurrentVolume();
        }

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"14,false"})
        //Количество начатий на кнопу next
    void shouldNextRadioStation(int countClick, boolean randomStartStation) {

        Radio radio = new Radio();

        if (randomStartStation) {
            // Выбираем случайную станцию
            selectRandomStation(radio);
        } else {
            // Выбираем станцию 6
            radio.setCurrentStation(6);
        }

        int countStation = radio.getMaxStation() - radio.getMinStation();
        countStation += 1; //zero based

        // Вычисляем ожидаемый результат
        int expected = countClick % countStation + radio.getCurrentStation();
        if (expected >= countStation) {
            expected = expected % countStation;
        }

        // Нажимаем кнопку next countClick раз
        for (int i = 0; i < countClick; i++) {
            radio.nextStation();
        }

        assertEquals(expected, radio.getCurrentStation());

    }

    @ParameterizedTest
    @CsvSource({"14,false"})
        //Количество начатий на кнопу next
    void shouldPrevRadioStation(int countClick, boolean randomStartStation) {
        Radio radio = new Radio();

        if (randomStartStation) {
            // Выбираем случайную станцию
            selectRandomStation(radio);
        } else {
            // Выбираем станцию 7
            radio.setCurrentStation(7);
        }

        int countStation = radio.getMaxStation() - radio.getMinStation();
        countStation += 1; //zero based

        // Вычисляем ожидаемый результат
        int expected = radio.getCurrentStation() - (countClick % countStation);
        if (expected < radio.getMinStation()) {
            expected += countStation;
        }

        // Нажимаем кнопку next countClick раз
        for (int i = 0; i < countClick; i++) {
            radio.prevStation();
        }

        assertEquals(expected, radio.getCurrentStation());

    }

}