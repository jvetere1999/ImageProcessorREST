//package com.jvetere.application;
//
//import com.jvetere.runtime.ImageUtils;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.input.Dragboard;
//import javafx.scene.input.TransferMode;
//import javafx.scene.layout.VBox;
//
//
//import java.util.ArrayList;
//
//public class DropBox {
//
//    public VBox                 me;
//    public ArrayList<String>    files;
//
//    public DropBox(String _text) {
//        Label           label;
//        Label           dropped;
//        Button          submit;
//        VBox            dragTarget;
//
//        label           = new Label(_text);
//        dropped         = new Label("");
//        submit          = new Button("Submit");
//        dragTarget      = new VBox();
//        files           = new ArrayList<>();
//
//        dragTarget.setAlignment(Pos.CENTER);
//        dragTarget.getChildren().addAll(label, dropped, submit);
//
//        dragTarget.setOnDragOver((dragEvent) -> {
//            if(dragEvent.getGestureSource() != dragTarget
//                    && dragEvent.getDragboard().hasFiles()) {
//                dragEvent.acceptTransferModes(TransferMode.ANY);
//            }
//            dragEvent.consume();
//        });
//
//        dragTarget.setOnDragDropped(dragEvent -> {
//            Dragboard board = dragEvent.getDragboard();
//            boolean success = false;
//            if (board.hasFiles()) {
//                dropped.setText(board.getFiles().toString());
//                System.out.println(board.getFiles().toString());
//                files.add(board.getFiles().toString());
//                success = true;
//            }
//            dragEvent.setDropCompleted(success);
//            dragEvent.consume();
//        });
//        submit.setOnAction( submitEvent -> ImageUtils.createImages(files));
//
//        me = dragTarget;
//    }
//}
