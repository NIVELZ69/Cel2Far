package dad.Cel2Far;

import javafx.application.Application;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Cel2FarApp extends Application {
	
	
	
	private TextField celsiusText, fahrenheitText;
	private DoubleProperty celsius = new SimpleDoubleProperty();
	//private DoubleProperty fahrenheit = new SimpleDoubleProperty();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		celsiusText = new TextField();
		celsiusText.setPrefColumnCount(10);
		
		fahrenheitText = new TextField();
		fahrenheitText.setPrefColumnCount(10);
		
		HBox celsiusBox = new HBox(5, new Label("Celsius"), celsiusText);
		celsiusBox.setAlignment(Pos.BASELINE_CENTER);
		
		HBox fahrenheitBox = new HBox(5, new Label("Fahrenheit"), fahrenheitText); 
		fahrenheitBox.setAlignment(Pos.BASELINE_CENTER);
		
		VBox root = new VBox(5, celsiusBox, fahrenheitBox);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Celsius to Fahrenheit");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//bindings
		
		celsiusText.textProperty().bindBidirectional(celsius, new NumberStringConverter());
		
		
		
		DoubleExpression cel2far = celsius.multiply(9.0 / 5.0).add(32);
		
		fahrenheitText.textProperty().bind(cel2far.asString("%.2f"));
		
	}
}
