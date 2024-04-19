package com.example.fxtableviewjava18;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {

    List<Student> studentList = List.of(
            new Student("William", 20),
            new Student("James", 22),
            new Student("Julius", 18));

    private ObservableList<Student> students = FXCollections.observableArrayList(studentList);

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane root = new Pane();
        Scene scene = new Scene(root, 520, 540);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        createUI(root);

        Button btnAdd = new Button("Add");
        btnAdd.setLayoutX(400);
        btnAdd.setLayoutY(400);
        root.getChildren().add(btnAdd);
        btnAdd.setOnAction(event -> {
            students.add(0,new Student("Børge", 60));

        });
/*
        Button btnDelete = new Button("Add");
        btnAdd.setLayoutX(400);
        btnAdd.setLayoutY(400);
        root.getChildren().add(btnAdd);
        btnAdd.setOnAction(event -> {
            students.add(0,new Student("Børge", 60));

        });*/
    }

    private void createUI(Pane root)
    {
        TableView<Student> tv = new TableView<>(students);

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>(studentList.get(0).nameProperty().getName()));
        TableColumn<Student, Integer> ageCol = new TableColumn<>("Age");
        //ageCol.
        ageCol.setCellValueFactory(new PropertyValueFactory<>(studentList.get(0).ageProperty().getName()));

        ageCol.prefWidthProperty().bind(tv.widthProperty().multiply(0.3));
        nameCol.prefWidthProperty().bind(tv.widthProperty().multiply(0.7));

        tv.getColumns().addAll(nameCol, ageCol);

        root.getChildren().addAll(tv);

    }

    public static void main(String[] args) {
        launch();
    }
}