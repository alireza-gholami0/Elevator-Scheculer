import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GUI extends Application {
    Building building;
    Label lbFloor1;
    Label lbFloor2;
    Label lbFloor3;
    TextField internalReq1;
    TextField internalReq2;
    TextField internalReq3;

    @Override
    public void start(Stage primaryStage){
        building = new Building(3, this);
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 600, 750);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);

        Label lbCF1 = new Label("Current Floor(1):   ");
        lbFloor1 = new Label("0");
        lbFloor1.setAlignment(Pos.TOP_LEFT);
        lbFloor1.setFont(new Font(80));
        Label lbCF2 = new Label("Current Floor(2):   ");
        lbFloor2 = new Label("0");
        lbFloor2.setAlignment(Pos.TOP_CENTER);
        lbFloor2.setFont(new Font(80));
        Label lbCF3 = new Label("Current Floor(3):   ");
        lbFloor3 = new Label("0");
        lbFloor3.setAlignment(Pos.TOP_RIGHT);
        lbFloor3.setFont(new Font(80));
        Label lbIn1 = new Label("Internal Request(0)");
        Button[][] btnInternal = new Button[3][15];
        for (int i = 0; i < btnInternal[0].length; i++) {
            btnInternal[0][i] = new Button(Integer.toString((i + 1)));
        }
        HBox hbIn1 = new HBox();
        hbIn1.getChildren().addAll(btnInternal[0]);
        hbIn1.setAlignment(Pos.TOP_CENTER);
        hbIn1.setSpacing(3);
        for (int i = 0; i < btnInternal[1].length; i++) {
            btnInternal[1][i] = new Button(Integer.toString((i + 1)));
        }
        HBox hbIn2 = new HBox();
        hbIn2.getChildren().addAll(btnInternal[1]);
        hbIn2.setAlignment(Pos.TOP_CENTER);
        hbIn2.setSpacing(3);
        for (int i = 0; i < btnInternal[2].length; i++) {
            btnInternal[2][i] = new Button(Integer.toString((i + 1)));
        }
        HBox hbIn3 = new HBox();
        hbIn3.getChildren().addAll(btnInternal[2]);
        hbIn3.setAlignment(Pos.TOP_CENTER);
        hbIn3.setSpacing(3);
        internalReq1 = new TextField();
        internalReq1.setMaxWidth(50);
        Button btnInternalAdd1 = new Button("Add");
        internalReq2 = new TextField();
        internalReq2.setMaxWidth(50);
        Button btnInternalAdd2 = new Button("Add");
        internalReq3 = new TextField();
        internalReq3.setMaxWidth(50);
        Button btnInternalAdd3 = new Button("Add");
        HBox hbIn = new HBox();
        hbIn.getChildren().addAll(internalReq1, internalReq2, internalReq3);
        hbIn.setSpacing(110);
        hbIn.setAlignment(Pos.TOP_CENTER);
        HBox hbAdd = new HBox();
        hbAdd.getChildren().addAll(btnInternalAdd1, btnInternalAdd2, btnInternalAdd3);
        hbAdd.setSpacing(110);
        hbAdd.setAlignment(Pos.TOP_CENTER);

        Label lbExternal = new Label("External Request");
        Button[] btnExternal = new Button[15];
        for (int i = 0; i < btnExternal.length; i++) {
            btnExternal[i] = new Button(Integer.toString((i + 1)));
        }
        HBox hbExt = new HBox();
        hbExt.getChildren().addAll(btnExternal);
        hbExt.setAlignment(Pos.TOP_CENTER);
        hbExt.setSpacing(3);
        vbox.getChildren().addAll(lbCF1, lbFloor1, hbIn1 ,new Separator(),
                lbCF2, lbFloor2, hbIn2, new Separator(),
                lbCF3, lbFloor3, hbIn3, new Separator(),
                lbExternal, hbExt);
        btnInternal[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(1,0);
            }
        });
        btnInternal[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(2,0);
            }
        });
        btnInternal[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(3,0);
            }
        });
        btnInternal[0][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(4,0);
            }
        });
        btnInternal[0][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(5,0);
            }
        });
        btnInternal[0][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(6,0);
            }
        });
        btnInternal[0][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(7,0);
            }
        });
        btnInternal[0][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(8,0);
            }
        });
        btnInternal[0][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(9,0);
            }
        });
        btnInternal[0][9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(10,0);
            }
        });
        btnInternal[0][10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(11,0);
            }
        });
        btnInternal[0][11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(12,0);
            }
        });
        btnInternal[0][12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(13,0);
            }
        });
        btnInternal[0][13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(14,0);
            }
        });
        btnInternal[0][14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(15,0);
            }
        });
        btnInternal[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(1,1);
            }
        });
        btnInternal[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(2,1);
            }
        });
        btnInternal[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(3,1);
            }
        });
        btnInternal[1][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(4,1);
            }
        });
        btnInternal[1][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(5,1);
            }
        });
        btnInternal[1][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(6,1);
            }
        });
        btnInternal[1][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(7,1);
            }
        });
        btnInternal[1][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(8,1);
            }
        });
        btnInternal[1][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(9,1);
            }
        });
        btnInternal[1][9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(10,1);
            }
        });
        btnInternal[1][10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(11,1);
            }
        });
        btnInternal[1][11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(12,1);
            }
        });
        btnInternal[1][12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(13,1);
            }
        });
        btnInternal[1][13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(14,1);
            }
        });
        btnInternal[1][14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(15,1);
            }
        });
        btnInternal[2][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(1,2);
            }
        });
        btnInternal[2][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(2,2);
            }
        });
        btnInternal[2][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(3,2);
            }
        });
        btnInternal[2][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(4,2);
            }
        });
        btnInternal[2][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(5,2);
            }
        });
        btnInternal[2][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(6,2);
            }
        });
        btnInternal[2][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(7,2);
            }
        });
        btnInternal[2][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(8,2);
            }
        });
        btnInternal[2][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(9,2);
            }
        });
        btnInternal[2][9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(10,2);
            }
        });
        btnInternal[2][10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(11,2);
            }
        });
        btnInternal[2][11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(12,2);
            }
        });
        btnInternal[2][12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(13,2);
            }
        });
        btnInternal[2][13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(14,2);
            }
        });
        btnInternal[2][14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleInternalRequest(15,2);
            }
        });
        btnExternal[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(1);
            }
        });
        btnExternal[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(2);
            }
        });
        btnExternal[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(2);
            }
        });
        btnExternal[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(3);
            }
        });
        btnExternal[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(4);
            }
        });
        btnExternal[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(5);
            }
        });
        btnExternal[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(6);
            }
        });
        btnExternal[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(7);
            }
        });
        btnExternal[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(8);
            }
        });
        btnExternal[8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(9);
            }
        });
        btnExternal[9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(10);
            }
        });
        btnExternal[10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(11);
            }
        });
        btnExternal[11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(12);
            }
        });
        btnExternal[12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(13);
            }
        });
        btnExternal[13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(14);
            }
        });
        btnExternal[14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                building.handleExternalRequest(15);
            }
        });
        btnInternalAdd1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                building.handleInternalRequest(Integer.parseInt(internalReq1.getText()),0);
                internalReq1.setText("");
            }
        });
        btnInternalAdd2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                building.handleInternalRequest(Integer.parseInt(internalReq2.getText()),1);
                internalReq2.setText("");
            }
        });
        btnInternalAdd3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                building.handleInternalRequest(Integer.parseInt(internalReq3.getText()),2);
                internalReq3.setText("");
            }
        });
        internalReq1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    building.handleInternalRequest(Integer.parseInt(internalReq1.getText()), 0);
                    internalReq1.setText("");
                }
            }
        });
        internalReq2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    building.handleInternalRequest(Integer.parseInt(internalReq2.getText()), 1);
                    internalReq2.setText("");
                }
            }
        });
        internalReq3.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    building.handleInternalRequest(Integer.parseInt(internalReq3.getText()), 2);
                    internalReq3.setText("");
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Elevator");
        primaryStage.show();
    }

    public void showFloor(int currentFloor, boolean stop, int index){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0:
                        lbFloor1.setText(Integer.toString(currentFloor));
                        if (stop) lbFloor1.setStyle("-fx-text-fill: red;");
                        else lbFloor1.setStyle("");
                        return;
                    case 1:
                        lbFloor2.setText(Integer.toString(currentFloor));
                        if (stop) lbFloor2.setStyle("-fx-text-fill: red;");
                        else lbFloor2.setStyle("");
                        return;
                    case 2:
                        lbFloor3.setText(Integer.toString(currentFloor));
                        if (stop) lbFloor3.setStyle("-fx-text-fill: red;");
                        else lbFloor3.setStyle("");
                        return;
                    default: return;
                }
            }
        });
    }
}
