package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product blouse = new Product(24, "Блуза", 2_300);
    Product skirt = new Product(33, "Юбка", 3_100);
    Product shoes = new Product(45, "Туфли", 5_750);
    Product bag = new Product(49, "Сумка", 4_199);

    public void setup() {
        repo.add(blouse);
        repo.add(skirt);
        repo.add(shoes);
        repo.add(bag);
    }

    // Проверка пустого репозитория
    @Test
    public void shouldEmptyRepository() {
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    // Проверка добавления продукта
    @Test
    public void shouldAddProduct() {
        repo.add(blouse);

        Product[] expected = {blouse};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    // Проверка добавления продукта с ID, который уже есть в базе данных
    @Test
    public void shouldAddExistingProductToDatabase() {
        setup();

        Assertions.assertThrows(AlreadyExistsException.class,
                () ->
                        repo.add(blouse));
    }

    // Удаление существующего продукта
    @Test
    public void shouldRemoveExistingProduct() {
        setup();

        repo.remove(45);
        Product[] expected = {blouse, skirt, bag};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    // Проверка удаления продукта с отрицательным ID
    @Test
    public void shouldRemoveNegativeArraySizeException() {
        setup();

        Assertions.assertThrows(NegativeArraySizeException.class,
                () ->
                        repo.remove(-100));
    }

    // Проверка удаления отсутствующего продукта
    @Test
    public void shouldRemoveNotExistingProduct() {
        setup();

        Assertions.assertThrows(NotFoundException.class,
                () ->
                        repo.remove(59));

    }
}