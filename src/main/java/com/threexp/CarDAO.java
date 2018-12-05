package com.threexp;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.threexp.utils.CassandraConnector;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAO {

    private final CassandraConnector connector = new CassandraConnector("cars");
    private final PreparedStatement add;
    private final PreparedStatement getAll;
    private final PreparedStatement remove;
    private final PreparedStatement updateBrand;
    private final PreparedStatement updateModel;
    private final PreparedStatement updatePower;
    private final PreparedStatement updateYear;
    private final PreparedStatement updatePrice;


    public CarDAO() {
        add = connector.getSession().prepare("insert into cars (id, brand, model, power, year, price) values (?, ?, ?, ?, ?, ?)");
        getAll = connector.getSession().prepare("select * from cars");
        updateBrand = connector.getSession().prepare("update cars set brand = ? where id = ?");
        updateModel= connector.getSession().prepare("update cars set model = ? where id = ?");
        updatePower = connector.getSession().prepare("update cars set power = ? where id = ?");
        updateYear = connector.getSession().prepare("update cars set year = ? where id = ?");
        updatePrice = connector.getSession().prepare("update cars set price = ? where id = ?");
        remove = connector.getSession().prepare("delete from cars where id = ?");
    }

    void add(Car car) {
        connector.getSession().execute(add.bind(
           car.getId(),
           car.getBrand(),
           car.getModel(),
           car.getPower(),
           car.getYear(),
           car.getPrice()
        ));
    }

    List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        ResultSet carsSet = connector.getSession().execute(getAll.bind());
        for (Row row : carsSet) {
            cars.add(new Car(
                    row.getInt(0),
                    row.getString(1),
                    row.getString(2),
                    row.getInt(3),
                    row.getInt(5),
                    row.getInt(4)
                )
            );
        }
        return cars;
    }

    void update(int id, String property, String value) {
        switch(property) {
            case "brand":
                connector.getSession().execute(updateBrand.bind(value, id));
                break;
            case "model":
                connector.getSession().execute(updateModel.bind(value, id));
                break;
            case "power":
                connector.getSession().execute(updatePower.bind(Integer.valueOf(value), id));
                break;
            case "year":
                connector.getSession().execute(updateYear.bind(Integer.valueOf(value), id));
                break;
            case "price":
                connector.getSession().execute(updatePrice.bind(Integer.valueOf(value), id));
                break;
        }
    }

    void remove(int id) {
        connector.getSession().execute(remove.bind(id));
    }
}
