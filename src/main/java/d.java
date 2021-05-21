/*import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Animals.Animal;
import sample.Places.Place;
import sample.Zoo;

public class d {

    ListView<Animal> animals = new ListView<>();
    private final Zoo zoo = new Zoo();

    @Override
    public void start(Stage stage)
    {
        logging = new TextArea();
        logging.setMaxWidth(300);
        logging.setMaxHeight(150);

        Label seasonLbl = new Label("Select Cage: ");
        Label fruitLbl = new Label("Select animal: ");

        ListView<Place> seasons = new ListView();
        seasons.getItems().addAll(zoo.places);
        seasons.setOrientation(Orientation.VERTICAL);
        seasons.setPrefSize(120, 100);

        seasons.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Place>()
        {
            @Override
            public void changed(ObservableValue<? extends Place> observableValue, Place place, Place t1) {
                animals.getItems().clear();
                animals.getItems().addAll(t1.getAnimals());
            }
        });


        animals.setOrientation(Orientation.VERTICAL);
        animals.setPrefSize(200, 100);
        animals.getItems().addAll(zoo.places.get(0).getAnimals());


        VBox seasonSelection = new VBox();
        seasonSelection.setSpacing(10);
        seasonSelection.getChildren().addAll(seasonLbl,seasons);

        VBox fruitSelection = new VBox();
        fruitSelection.setSpacing(10);
        fruitSelection.getChildren().addAll(fruitLbl,animals);

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);
        pane.addColumn(0, seasonSelection);
        pane.addColumn(1, fruitSelection);
        pane.addColumn(2, logging);

        pane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("A simple ListView Example");
        stage.show();
    }
}
*/