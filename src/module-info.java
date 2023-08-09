module javafxex {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.base;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
