package de.tudresden.inf.st.most;

import drast.Log;
import drast.model.DrAST;
import drast.model.DrASTSettings;
import drast.model.TreeFilter;
import drast.views.gui.DrASTGUI;
import drast.views.gui.GUIData;
import drast.views.gui.controllers.Controller;
import drast.views.gui.graph.GraphView;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DrAstRunner extends DrASTGUI {

  public static void main(String[] args) {

    openView();
    System.exit(0);

  }

  private static final GUIData mon = new GUIData();
  private static Controller con;
  private static boolean guiHasBeenCreated = false;

  private static void openView() {
    guiHasBeenCreated = true;
    DrASTSettings.put(DrASTSettings.PREV_JAR, "build/libs/jastadd-most-1.0-SNAPSHOT.jar");
    launch(new String[0]);
    con.onApplicationClose();
  }

  public void setRoot(Object root) {
    long timeStart = System.currentTimeMillis();
    DrAST newAst = new DrAST(root, TreeFilter.readFilter(con.getFilter()));
    Log.info("Filter update: done after %d ms", new Object[]{System.currentTimeMillis() - timeStart});
    Platform.runLater(() -> {
      mon.reset(newAst);
      if (guiHasBeenCreated) {
        con.onSetRoot();
      } else {
        openView();
      }

    });
  }

  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    Parent rootView = (Parent)loader.load(this.getClass().getResource("/main.fxml").openStream());
    con = (Controller)loader.getController();
    mon.setParentStage(stage);
    mon.setController(con);
    mon.setDrASTUI(this);
    mon.setStage(stage);
    GraphView graphview = new GraphView(mon);
    graphview.setOnMouseClicked((event) -> {
      graphview.getParent().requestFocus();
    });
    mon.setGraphView(graphview);
    con.init(mon);
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    stage.setTitle("DrAST 1.2.2");
    stage.setScene(new Scene(rootView, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight() - 100.0D));
    stage.show();
    ScrollPane center = (ScrollPane)rootView.lookup("#graphViewScrollPane");
    center.setContent(graphview);
    Platform.runLater(() -> {
      graphview.setPreferredSize((int)center.getWidth(), (int)center.getHeight());
    });
    con.loadPreviousFilter();
  }

}
