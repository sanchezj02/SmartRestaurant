/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Justin Sanchez
 */
public class SmartRestaurant extends Application {
    //variables
    public int dishnum = 0;
    Label dname = new Label();
    Label ddesc = new Label();
    Label dprice = new Label();
    ArrayList<Dish> dishes = new ArrayList<>();  
    ArrayList<Scene> scenes = new ArrayList<>();
    ArrayList<GridPane> grids = new ArrayList<>();
    ArrayList<Button> prevbutts = new ArrayList<>();
    ArrayList<Button> nextbutts = new ArrayList<>();
    //setting up the primary stage here
    @Override
    public void start(Stage primaryStage) {
        
        //How I want layout arranged
        /*
        GridPane mainlayout = new GridPane();
        mainlayout.setAlignment(Pos.CENTER);
        mainlayout.setHgap(10);
        mainlayout.setVgap(10);
        mainlayout.setPadding(new Insets(25,25,5,25)); //padding is 25 px all around
        mainlayout.setGridLinesVisible(true);
        mainlayout.add(dname,1,0);
        mainlayout.add(ddesc,1,1);
        mainlayout.add(dprice,1,2);
        */
        //buttons
        /*
        Button prevbutt = new Button("<- Prev");
        HBox pbox = new HBox(10);
        pbox.setAlignment(Pos.BOTTOM_LEFT);
        pbox.getChildren().add(prevbutt);
        mainlayout.add(pbox,0,4);
                
        Button nextbutt = new Button("-> Next");
        HBox nbox = new HBox(10);
        nbox.setAlignment(Pos.BOTTOM_RIGHT);
        nbox.getChildren().add(nextbutt);
        mainlayout.add(nbox,2,4); //col and row
   */
        //creates list of dishes from config.txt
        String name = "";
        String imagename = "";
        String description = "";
        String price = "";
        int size = 4;  
        Scanner sc = new Scanner(getClass().getResourceAsStream("/otherfiles/config.txt")); 
        for (int i = 0; i < size; i++) 
        {
                sc.nextLine();
                for (int j = 0; j < 4; j++) {
                    String line = sc.nextLine();
                    if(line.contains("Name: ")){
                        name = line.substring(6);
                        System.out.println(name);
                    }else if(line.contains("Description: ")){
                        description = line.substring(13);
                        System.out.println(description);
                    }else if(line.contains("Price: ")){
                        price = line.substring(7);
                        System.out.println(""+price);
                    }else if(line.contains("Image: ")){
                        imagename = "/pictures/" + line.substring(7);
                        System.out.println(imagename);
                    }
                }
                Dish addeddish= new Dish(name,description,imagename,price);
                dishes.add(addeddish);
        }
        for (int k = 0; k<4;k++)
        {
        Image image = new Image(dishes.get(k).getimagename());
        ImageView iview = new ImageView();
        iview.setImage(image);
        iview.setPreserveRatio(true);
        iview.setFitHeight(400);
        iview.setFitWidth(400);
        dname = new Label(dishes.get(k).getname());
        ddesc = new Label(dishes.get(k).getdesc());
        ddesc.setWrapText(true);
        dname.setWrapText(true);
        dprice = new Label("$"+dishes.get(k).getprice());
        GridPane addedgrid = new GridPane();
        addedgrid.setAlignment(Pos.CENTER);
        addedgrid.setHgap(10);
        addedgrid.setVgap(10);
        addedgrid.setPadding(new Insets(25,25,5,25)); //padding is 25 px all around
        //addedgrid.setGridLinesVisible(true);
        addedgrid.add(dname,1,0);
        addedgrid.add(ddesc,2,1);
        addedgrid.add(dprice,1,2);
        addedgrid.add(iview,1,1);
        
        Button prevbutt = new Button("<- Prev");
        HBox pbox = new HBox(10);
        pbox.setAlignment(Pos.BOTTOM_LEFT);
        pbox.getChildren().add(prevbutt);
        addedgrid.add(pbox,1,4);
                
        Button nextbutt = new Button("-> Next");
        HBox nbox = new HBox(10);
        nbox.setAlignment(Pos.BOTTOM_RIGHT);
        nbox.getChildren().add(nextbutt);
        addedgrid.add(nbox,2,4); //col and row
        prevbutts.add(prevbutt);
        nextbutts.add(nextbutt);
        grids.add(addedgrid);
        Scene addedscene = new Scene(grids.get(k),750,600);
        scenes.add(addedscene);
        
      
       
        prevbutts.get(k).setOnAction((event) -> {
            primaryStage.close();
            if (dishnum == 0)//dish1
            {
                dishnum = 3; //last dish
                primaryStage.setScene(scenes.get(dishnum)); //displays dish one first
                primaryStage.show();
            }
            else
            {
                dishnum = dishnum - 1;
                primaryStage.setScene(scenes.get(dishnum)); //displays dish one first
                primaryStage.show();
            }
        });
   
        nextbutts.get(k).setOnAction((event) -> {
            primaryStage.close();
            if (dishnum == 3)
            {
                dishnum = 0;
                primaryStage.setScene(scenes.get(dishnum)); //displays dish one first
                primaryStage.show();
            }
            else
            {
                dishnum = dishnum +1;
                primaryStage.setScene(scenes.get(dishnum)); //displays dish one first
                primaryStage.show();
            }
        });
       
        }
        //Scene scene = new Scene(grid,750, 600); //(root, w , h)

        primaryStage.setTitle("Smart Restaurant");
       
        primaryStage.setScene(scenes.get(dishnum)); //displays dish one first
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
