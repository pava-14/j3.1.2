package ru.netology.radio;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    void initRadio(Radio radio) {
        radio.setMaxVolume(10);
        radio.setMinVolume(0);
        radio.setMaxStation(9);
        radio.setMinStation(0);
    }

    @Test
    void shouldSetCurrentStation() {

        Radio radio = new Radio();
        initRadio(radio);

        Random random = new Random();

        // Клиент должен иметь возможность выставлять номер
        // радиостанции с цифрового пульта (вводя числа 0 - 9)
        int expected = random.nextInt(10);
        radio.setCurrentStation(expected);

        assertEquals(expected, radio.getCurrentStation());

    }

//    @Test
//    void shouldSetCurrentVolume() {
//
//    }

    @Test
    void shouldIncreaseCurrentVolume() {

        Radio radio = new Radio();
        initRadio(radio);

        // Нажимаем кнопку увеличения громкости
        for (int i = 0; i < 20 ; i++) {
            radio.increaseCurrentVolume();
        }

        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseCurrentVolume() {

        Radio radio = new Radio();
        initRadio(radio);

        // Нажимаем кнопку уменьшения громкости
        for (int i = 0; i < 20 ; i++) {
            radio.decreaseCurrentVolume();
        }

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldNextRadioStation() {
        Radio radio = new Radio();
        initRadio(radio);
        int expected = 2;

        // Нажимаем кнопку next станция
        for (int i = 0; i < 12 ; i++) {
            radio.nextStation();
            System.out.println(radio.getCurrentStation());
        }

        assertEquals(expected , radio.getCurrentStation());

    }

    @Test
    void shouldPrevRadioStation() {
    }


}