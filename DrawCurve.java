import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

// Equation: 2x^3 - 3x^2 + 5x + 7

public class DrawCurve extends Application{

	public void start(Stage primaryStage){
		
		ArrayList<Double> xList = new ArrayList<Double>();
		ArrayList<Double> yList = new ArrayList<Double>();
		
		for(Double x = -5.0; x <= 10.0; x++){
			xList.add(x);
			double y = 0;
			y = 2*(Math.pow(x, 3)) - 3*(Math.pow(x, 2)) + 5*x + 7;
			
			yList.add(y);
		}
		Pane pane = new Pane();
		Path path = new Path();
		
		double maxY = Collections.max(yList);
		
		double maxNegativeX = Collections.min(xList);
		double maxNegativeY = Collections.min(yList);
		double scaledY = 0.0;
		double scaledX = 0.0;
		path.getElements().add(new MoveTo(0, 1000));
		
		//Graph
		for(int i = 0; i < xList.size(); i++){
			scaledY = ((yList.get(i))/maxY) * 1000;
			scaledY += (-1 * maxNegativeY);
			scaledX = (i / 16.0) * 500;
			
			path.getElements().add(new LineTo(scaledX, 500 - scaledY));
		}
		
		// Draw x and y plane
		
		
		pane.getChildren().add(path);
		
		Scene scene = new Scene(pane, 500, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String args[]){
		launch(args);
	}
}
