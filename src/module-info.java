module Teest {
	requires javafx.controls;
	requires java.logging;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
