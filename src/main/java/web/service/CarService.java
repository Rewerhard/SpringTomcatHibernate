package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Priora", "Black", 2012));
        cars.add(new Car("BMV", "Wite", 2022));
        cars.add(new Car("Lada", "Blue", 2019));
        cars.add(new Car("Volvo", "Grey", 1987));
        cars.add(new Car("RX", "Red", 2002));
    }

    public List<Car> showRequestCars(int count) {
        if (count <= 0) {
            return new ArrayList<>();
        }
        return cars.stream().limit(count).collect(Collectors.toList());

    }
}
