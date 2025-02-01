package ru.netology;

public class ShopRepository {

    private Product[] products = new Product[0];

    //Вспомогательный метод для имитации добавления элемента в массив
    //return — возвращает новый массив, который выглядит, как тот, что мы передали, но с добавлением нового элемента в конец
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    // Метод добавления товара в репозиторий
    // AlreadyExistsException - исключение, если товар с таким ID уже есть в базе данных
    public void add(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException("Element with id: " + product.getId() + " is already in the database");
        }
        products = addToArray(products, product);
    }

    // Метод вывода всех добавленных элементов в массиве.
    public Product[] findAll() {

        return products;
    }

    // Метод для поиска товара в репозитории по ID
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Метод удаления товара из репозитория
    public void remove(int id) {
        if (id < 0) {
            throw new NegativeArraySizeException("Element with id: " + id + " is less than 0");
        }
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}