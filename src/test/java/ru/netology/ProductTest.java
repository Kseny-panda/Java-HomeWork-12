package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product = new Product();

    // Проверка вывода названия товара
    @Test
    public void shouldGetTitle() {
        Product blouse = new Product(24, "Блуза", 2_300);

        String expected = "Блуза";
        Assertions.assertEquals(expected, blouse.getTitle());
    }

    // Проверка изменения названия товара
    @Test
    public void shouldSetTitle() {
        Product blouse = new Product(24, "Блуза", 2_300);

        blouse.setTitle("Блузка");
        String expected = "Блузка";
        Assertions.assertEquals(expected, blouse.getTitle());
    }

    // Проверка вывода стоимости товара
    @Test
    public void shouldGetPrice() {
        Product bag = new Product(49, "Сумка", 4_199);

        int expected = 4_199;
        Assertions.assertEquals(expected, bag.getPrice());
    }

    // Проверка изменения стоимости товара
    @Test
    public void shouldSetPrice() {
        Product bag = new Product(49, "Сумка", 4_199);

        bag.setPrice(4_799);
        int expected = 4_799;
        Assertions.assertEquals(expected, bag.getPrice());
    }
}