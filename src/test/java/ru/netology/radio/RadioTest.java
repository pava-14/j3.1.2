package ru.netology.radio;

import org.junit.jupiter.api.Test;

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

//    @Test
//    void shouldSetCurrentVolume() {
//
//    }

    @Test
    void shouldIncreaseCurrentVolume() {

        Radio radio = new Radio();

        // Нажимаем кнопку увеличения громкости
        for (int i = 0; i < 20; i++) {
            radio.increaseCurrentVolume();
        }

        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseCurrentVolume() {

        Radio radio = new Radio();

        // Нажимаем 20 раз кнопку уменьшения громкости
        for (int i = 0; i < 20; i++) {
            radio.decreaseCurrentVolume();
        }

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldNextRadioStation() {

        Radio radio = new Radio();

        selectRandomStation(radio);

        // Количество начатий на кнопу next
        int countClick = 13;

        int countStation = radio.getMaxStation() - radio.getMinStation();
        countStation += 1; //zero based

        int expected = countClick % countStation + radio.getCurrentStation();

        // Нажимаем кнопку next станция
        for (int i = 0; i < countClick; i++) {
            radio.nextStation();
            System.out.println(radio.getCurrentStation());
        }

        assertEquals(expected, radio.getCurrentStation());

    }

    @Test
    void shouldPrevRadioStation() {
    }


}