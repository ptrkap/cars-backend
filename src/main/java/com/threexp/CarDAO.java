package com.threexp;

import com.datastax.driver.core.BoundStatement;
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
    private final PreparedStatement get;
    private final PreparedStatement remove;


    public CarDAO() {
        add = connector.getSession().prepare("insert into cars (id, brand, model, power, year, price) values (?, ?, ?, ?, ?, ?)");
        get = connector.getSession().prepare("select * from cars");
//        update = connector.getSession().prepare("")
        remove = connector.getSession().prepare("delete from cars where id = ?");
    }

    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        ResultSet carsSet = connector.getSession().execute(get.bind());
        for (Row row : carsSet) {
            cars.add(new Car(
                    row.getInt(0),
                    row.getString(1),
                    row.getString(2),
                    row.getInt(3),
                    row.getInt(4),
                    row.getInt(5)
                )
            );
        }
        return cars;
    }
}
