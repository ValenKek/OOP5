package DB;

import Animals.Animal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalJDBCDao implements IDao<Animal> {
    Connection connection;
    Statement statement;

    public AnimalJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Animal> get(int id) {
        Optional<Animal> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [animal] WHERE id=" + id);

            if (rs.next()) {
                result = DBUtils.getAnimal(rs);
                if(result.isEmpty()){
                    return Optional.empty();
                }
            }
            DBUtils.close(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Optional<Animal>> getAll() {
        List<Optional<Animal>> animals = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [animal]");

            while (rs.next()) {
                animals.add(DBUtils.getAnimal(rs));
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animals;
    }

    @Override
    public boolean insert(Animal animal) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "INSERT INTO Animal(name, behaviorId, cost, date) " +
                            "VALUES('" + animal.getName() + "'," + animal.getBehaviorId() + "," + animal.getCost() + "," + animal.getDate().getTime() + ");");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Animal inserted");
        return result;
    }

    @Override
    public boolean update(Animal animal) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE Animal" +
                            "SET Name = '" + animal.getName() + "'" +
                            "Cost = " + animal.getCost() +
                            "WHERE id = " + animal.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Animal animal) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Animal WHERE id=" + animal.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Animal deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Animal");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
