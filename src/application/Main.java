package application;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 

public class Main extends Application {
	// takes in a csv file and reads it
	private void readCSV() {
		
		String CsvFile = "sample1.csv";
		String FieldDelimiter = ",";
		
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(CsvFile));
			
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);
				
				Table table = new Table(fields[0], fields[1], fields[2],
						fields[3], fields[4], fields[5], fields[6], fields[7]);
				dataList.add(table);	
			}
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName())
			.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName())
			.log(Level.SEVERE, null, ex);
		}
		
	}
	
	// create tableView
    private final TableView<Table> tableView = new TableView<>();
    private final ObservableList<Table> dataList = FXCollections.observableArrayList();
 
    // creates all the columns
	@Override
    public void start(Stage stage) {
		Group root = new Group();
        stage.setTitle("Objektivering");
        stage.setWidth(678);
        stage.setHeight(490);
        
        // adds some text at the top of the table
        final Label label = new Label("Orderlista");
        label.setFont(new Font("Arial", 20));
        
        tableView.setEditable(true);
 
        // creates every column and sets names them
        TableColumn<Table, String> columnF1 = new TableColumn<>("f1");
        columnF1.setCellValueFactory(new PropertyValueFactory<>("f1"));
 
        TableColumn<Table, String> columnF2 = new TableColumn<>("f2");
        columnF2.setCellValueFactory(new PropertyValueFactory<>("f2"));
 
        TableColumn<Table, String> columnF3 = new TableColumn<>("f3");
        columnF3.setCellValueFactory(new PropertyValueFactory<>("f3"));
 
        TableColumn<Table, String> columnF4 = new TableColumn<>("f4");
        columnF4.setCellValueFactory(new PropertyValueFactory<>("f4"));
 
        TableColumn<Table, String> columnF5 = new TableColumn<>("f5");
        columnF5.setCellValueFactory(new PropertyValueFactory<>("f5"));
 
        TableColumn<Table, String> columnF6 = new TableColumn<>("f6");
        columnF6.setCellValueFactory(new PropertyValueFactory<>("f6"));
        
        TableColumn<Table, String> columnF7 = new TableColumn<>("f7");
        columnF7.setCellValueFactory(new PropertyValueFactory<>("f7"));
        
        TableColumn<Table, String> columnF8 = new TableColumn<>("f8");
        columnF8.setCellValueFactory(new PropertyValueFactory<>("f8"));
 
        tableView.setItems(dataList);
        
        tableView.getColumns().addAll(columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7, columnF8);
 
        // creates the box and edits it
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(label, tableView);
 
        root.getChildren().add(vBox);
 
        //  shows the scene
        stage.setScene(new Scene(root));
        stage.show();
 
        readCSV();
    }
 
	
    public static void main(String[] args) {
        launch(args);
    }
 
}