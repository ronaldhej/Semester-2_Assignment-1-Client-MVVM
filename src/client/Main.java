package client;

import javafx.application.Application; import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args) {
        launch(Main.class);
    }

    public void start(Stage stage)
    {
        Model model = new ModelManager();
        ViewModelClient viewModel = new ViewModelClient(model);
        MainView view = new MainView(viewModel);
        view.start(stage);
    }
}

