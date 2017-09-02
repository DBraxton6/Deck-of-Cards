import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class CardDeck extends Application{
	
	StackPane stackpane = new StackPane();
	public static final int ASIZE = 55;
	public void start(Stage primaryStage){

		//card array
		int DeckOfCards[] = new int[ASIZE];      
		for( int i = 0 ; i < ASIZE ; i++ )  
			DeckOfCards[i] = i + 1;
		
		//cards onto stackpane
		for(int j = 53; j >= 0; j--){

			stackpane.getChildren().add(new ImageView(new Image("image/card/" + DeckOfCards[j]+ ".png")));
		}

		//exit program button
		BorderPane bp = new BorderPane();
		Button exit = new Button("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>(){

			@Override

			public void handle(ActionEvent event) {
				System.exit(0);
				}
			}
		);
		
		//previous card button
		Button previous = new Button("Previous");
		previous.setOnAction(new EventHandler<ActionEvent>(){

			@Override

			public void handle(ActionEvent event) {


				stackpane.getChildren().get(0).toFront();
				}
			}
		);
		
		//reset entire deck button
		Button reset = new Button("Reset");
		reset.setOnAction(new EventHandler<ActionEvent>(){

			@Override

			public void handle(ActionEvent event) {

				bp.getChildren().remove(stackpane);
				StackPane sp = new StackPane();


				//stackpane in beginning order
				for(int i = 53; i >= 0; i--){
					sp.getChildren().add(new ImageView(new Image("image/card/" + DeckOfCards[i]+ ".png")));
				}
				//stackpane to the center of borderpane
				stackpane = sp;
				bp.setCenter(sp);
				}
			}
		);
		
		//next card button
		Button next = new Button("Next");
		next.setOnAction(new EventHandler<ActionEvent>(){

			@Override

			public void handle(ActionEvent event) {

				stackpane.getChildren().get(53).toBack();
				}
			}
		);
		
		// button holders - vbox & hbox
		VBox vbox = new VBox();
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		HBox hbox2 = new HBox();

		//top label (title) and bottom label (program credits)
		
		Label title = new Label("Assignment 5 - Card Deck");
	
		Label credits = new Label("Program designed and developed by Daisha Braxton");
		title.setAlignment(Pos.TOP_CENTER);
		credits.setAlignment(Pos.BOTTOM_CENTER);

		//font changes
		final Text font = new Text();
		title.setTextFill(Color.DARKGREEN);
		title.setStyle("-fx-font: 24 stencil;");
		credits.setTextFill(Color.RED);
		credits.setStyle("-fx-font: 14 tahoma;");
		
		
		//center aligning vbox and hbox
		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox2.setAlignment(Pos.CENTER_RIGHT);
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);

		//add buttons and labels to vbox/hbpx
		vbox.getChildren().addAll(reset,exit);
		vbox2.getChildren().addAll(next,previous);
		hbox.getChildren().add(title);
		hbox2.getChildren().add(credits);


		primaryStage.setTitle("Card Deck");

		//vbox/hbox added to borderpane
		bp.setTop(hbox);
		bp.setBottom(hbox2);
		bp.setLeft(vbox);
		bp.setRight(vbox2);
		bp.setCenter(stackpane);
		
		bp.setStyle("-fx-background-image: url(\"http://thumbs.dreamstime.com/x/abstract-card-game-boom-over-white-background-29711633.jpg\");-fx-background-size: 400, 400;-fx-background-repeat: no-repeat;");

		//borderpane onto scene
		Scene scene = new Scene(bp,350,350);
		
		//scene onto stage
		primaryStage.setScene(scene);
		primaryStage.show();



	}   


	public static void main(String[] args){

		launch(args);
	}
}