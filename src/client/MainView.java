package client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*; import javafx.stage.Stage;

import static javafx.application.Application.*;

public class MainView
{
    private Stage primaryStage;
    private ViewClient currentView;
    private ViewModelClient viewModel;

    public MainView(ViewModelClient viewModel)
    {
        this.viewModel = viewModel;
    }
    public void start(Stage primaryStage)
    {
        System.out.println("Mainview class started");
        this.primaryStage = primaryStage;
        openClientView();
    }
    public void openClientView()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ViewClient.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 400);
            currentView = loader.getController();
            currentView.init(viewModel, "Client", scene);
        } catch (Exception e) {e.printStackTrace();}

        primaryStage.setScene(currentView.getScene());
        primaryStage.setTitle(currentView.getTitle());
        primaryStage.show();
    }
}
