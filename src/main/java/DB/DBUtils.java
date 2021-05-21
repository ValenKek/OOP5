package DB;

import Animals.Animal;
import Behaviors.Behaviors;
import Unils.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;

public class DBUtils {
    public static void close(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet){
        if(resultSet == null) return;
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void initBD(Connection connection) throws SQLException {
        connection = ConnectionFactory.getConnection();
        dropDBTable(connection);
        Statement stmt = connection.createStatement();
        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS CageBehavior (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL)");
        executeQuery(stmt,
                "INSERT INTO CageBehavior(Name) " +
                        "VALUES " +
                        "('Herbaceous')," +
                        "('Predator')");
        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS AnimalBehavior (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL)");
        executeQuery(stmt,
                "INSERT INTO AnimalBehavior(Name) " +
                        "VALUES " +
                        "('Herbaceous')," +
                        "('Predator')");
        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS Animal (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT          NOT NULL," +
                        "behaviorId INT     NOT NULL," +
                        "cost INT           NOT NULL," +
                        "date INT           NOT NULL," +
                        "FOREIGN KEY(behaviorId) REFERENCES AnimalBehavior(id))");
        stmt.close();
    }
    public static void dropDBTable(Connection connection) throws SQLException {
        Statement  stmt = connection.createStatement();
        executeQuery(stmt,
                "drop table if exists Animal;drop table if exists AnimalBehavior; drop table if exists CageBehavior;");
    }
    public static void executeQuery(Statement stmt, String query) throws SQLException {
        stmt.executeUpdate(query);
    }
    public static Optional<Animal> getAnimal(ResultSet rs) throws SQLException {

        Animal animal = new Animal();

        animal.setId(rs.getInt("id"));
        animal.setBehaviorId(rs.getInt("behaviorId"));
        animal.setName(rs.getString("name"));
        animal.setCost(rs.getInt("cost"));
        animal.setDate(new Date(rs.getLong("date")));
        animal.setBehavior(Utils.fromIdToAnimalBehavior(animal.getBehaviorId()));
        return Optional.of(animal);
    }
}
