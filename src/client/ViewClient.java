package client;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;


public class ViewClient {

    @FXML private TextField usernameField;
    @FXML private Button sendButton;
    @FXML private TextField textField;

    private ViewModelClient viewModel;
    private String title;
    private Scene scene;

    public ViewClient()
    {

    }

   public void init(ViewModelClient viewModel, String title, Scene scene)
   {
       this.title = title;
       this.scene = scene;
       this.viewModel = viewModel;

       usernameField.textProperty().bindBidirectional(viewModel.usernameProperty());
       textField.textProperty().bindBidirectional(viewModel.textProperty());
   }

   @FXML private void sendButtonPressed()

   {
       System.out.println("Button pressed - view client");
       viewModel.sendMessage();
   }

   @FXML void onEnter(Event event)
   {
       viewModel.sendMessage();
   }

   public String getTitle() {return title;}

   public Scene getScene() {return scene;}
}
