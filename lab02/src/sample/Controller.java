package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;
import lab01.logic.CountingSort;
import lab01.logic.InsertSort;
import lab01.logic.QuickSort;
import lab01.model.IElement;
import lab01.model.IntElement;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;

import javax.xml.soap.Text;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Controller implements Initializable {

    private List<IntElement> listInt = new ArrayList<>();
    private List<IElement> listFloat = new ArrayList<>();
    private List<String> valueTypeList = new ArrayList<>();
    ObservableList<String> messyList = FXCollections.observableArrayList();
    ObservableList<String> sortedListInt = FXCollections.observableArrayList();
    ObservableList<String> sortedListFloat = FXCollections.observableArrayList();
    ObservableList<String> stringMessyList = FXCollections.observableArrayList();
    ObservableList<String> stringSortedList = FXCollections.observableArrayList();
    private int isFloat = 0;
    int language = 0; //0-polski, 1-angielski
    DateTimeFormatter dateFormat;
    LocalDateTime date = LocalDateTime.now();

    @FXML
    private ComboBox<String> sortersComboBox;

    @FXML
    private TextField inputValueTextField;

    @FXML
    private TextField inputStringTextField;

    @FXML
    private ListView showMessyListView;

    @FXML
    private ListView showSortedListView;

    @FXML
    private ListView showMessyStringListView;

    @FXML
    private ListView showSortedStringListView;

    @FXML
    private TextField showTypeSorter;

    @FXML
    private TextField actualDate;

    @FXML
    private ImageView imageView;

    @FXML
    private Menu languageMenu;

    @FXML
    private Button sortButton;

    @FXML
    private Button addButton;

    @FXML
    private Menu aboutMenu;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Label text1;

    @FXML
    private Label text2;

    @FXML
    private Label text3;

    @FXML
    private Label text4;

    @FXML
    private Label text5;

    @FXML
    private Label text6;

    @FXML
    private TextField elements;

    @FXML
    public void putElement(){

        if(!inputValueTextField.getText().equals("")) {
            //int
            IntElement element = new IntElement(inputStringTextField.getText(), Float.parseFloat(inputValueTextField.getText().replace(',', '.')));
            listInt.add(element);

            //float
            IElement elementf = new IntElement(inputStringTextField.getText(), Float.parseFloat(inputValueTextField.getText().replace(',', '.')));
            listFloat.add(elementf);

            //zawartosc listy
            valueTypeList.add(inputValueTextField.getText().replace(',', '.'));
            showMessyListView.getItems().clear();
            showMessyStringListView.getItems().clear();
            for (int j = 0; j <= listFloat.size() - 1; j++) {
                if (language == 0) {
                    messyList.add(String.valueOf(listFloat.get(j).getValue()).replace('.', ','));
                    stringMessyList.add(listFloat.get(j).getName().replace('.', ','));
                } else {
                    messyList.add(String.valueOf(listFloat.get(j).getValue()));
                    stringMessyList.add(listFloat.get(j).getName());
                }
            }
            showMessyListView.setOrientation(Orientation.HORIZONTAL);
            showMessyStringListView.setOrientation(Orientation.HORIZONTAL);
            showMessyListView.setItems(messyList);
            showMessyStringListView.setItems(stringMessyList);
        }else if(language == 0){
            alertValuePL();
        }else{
            alertValueEN();
        }
    }


    //uruchomiwnie wybranego algorytmu
    @FXML
    private void start(){

        showSortedListView.getItems().clear();
        showSortedStringListView.getItems().clear();

        //czy wystepuje liczba typu float
        for(int j = 0; j <= listFloat.size()-1; j++){
            if(valueTypeList.get(j).indexOf('.') != -1) {
                isFloat++;
            }
        }
        //sprawdzenie czy wybrano algorytm
        if(sortersComboBox.getSelectionModel().getSelectedItem() == null){
            if (language == 0) {
                alertAlgorithmPL();
            }else
                alertAlgorithmEN();
        }
        //sprawdzenie czy lista zawiera elementy, To jeszcze nie dziala
        if(listInt.size() == 0){
            if (language == 0) {
                alertValuePL();
            }else
                alertValueEN();
        }
        //sortowanie intów
        if(isFloat==0) {
            if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Quick Sort")) {
                new QuickSort().solveInt(listInt);
                showTypeSorter.setText("Quick Sort Int");
            } else if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Count Sort")) {
                new CountingSort().solveInt(listInt);
                showTypeSorter.setText("Count Sort Int");
            } else if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Insert Sort")) {
                new InsertSort().solveInt(listInt);
                showTypeSorter.setText("Insert Sort Int");
            }
            for (int j = 0; j<= listInt.size()-1; j++){
                if(language == 0){
                    sortedListInt.add(String.valueOf(listInt.get(j).getValue()).replace('.', ','));
                    stringSortedList.add(listInt.get(j).getName().replace('.', ','));
                }else{
                sortedListInt.add(String.valueOf(listInt.get(j).getValue()));
                stringSortedList.add(listInt.get(j).getName());
                }
            };
            showSortedListView.setOrientation(Orientation.HORIZONTAL);
            showSortedStringListView.setOrientation(Orientation.HORIZONTAL);
            showSortedStringListView.setItems(stringSortedList);
            showSortedListView.setItems(sortedListInt);
            if (language == 0)
                elementsPL();
            else
                elementsEN();
        }
        //sortowanie float
        else if(isFloat>0) {
            if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Quick Sort")) {
                new QuickSort().solveFloat(listFloat);
                showTypeSorter.setText("Quick Sort Float");
                for (int j = 0; j<= listFloat.size()-1; j++){
                    if (language == 0){
                        sortedListFloat.add(String.valueOf(listFloat.get(j).getValue()).replace('.', ','));
                        stringSortedList.add(listFloat.get(j).getName().replace('.', ','));
                    } else{
                    sortedListFloat.add(String.valueOf(listFloat.get(j).getValue()));
                    stringSortedList.add(listFloat.get(j).getName());
                    }
                };
                showSortedListView.setOrientation(Orientation.HORIZONTAL);
                showSortedStringListView.setOrientation(Orientation.HORIZONTAL);
                showSortedStringListView.setItems(stringSortedList);
                showSortedListView.setItems(sortedListFloat);
                if (language == 0)
                    elementsPL();
                else
                    elementsEN();
            } else if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Count Sort")) {
                    if (language == 0) {
                        alertCSPL();
                    } else
                        alertCSEN();
            } else if (sortersComboBox.getSelectionModel().getSelectedItem().equals("Insert Sort")) {
                new InsertSort().solveFloat(listFloat);
                showTypeSorter.setText("Insert Sort Float");
                for (int j = 0; j<= listFloat.size()-1; j++) {
                    if (language == 0) {
                        sortedListFloat.add(String.valueOf(listFloat.get(j).getValue()).replace('.', ','));
                        stringSortedList.add(listFloat.get(j).getName().replace('.', ','));
                    } else {
                        sortedListFloat.add(String.valueOf(listFloat.get(j).getValue()));
                        stringSortedList.add(listFloat.get(j).getName());
                    }
                }
                showSortedListView.setOrientation(Orientation.HORIZONTAL);
                showSortedStringListView.setOrientation(Orientation.HORIZONTAL);
                showSortedStringListView.setItems(stringSortedList);
                showSortedListView.setItems(sortedListFloat);
                elements.setText(String.valueOf(sortedListFloat.size()));
                if (language == 0)
                    elementsPL();
                else
                    elementsEN();
            }
        }

    }

    //inicjalizacja kontrolera, przypisanie poczatkowych wartosci
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        polish();
        ObservableList<String> sorter = sortersComboBox.getItems();
        sorter.add("Quick Sort");
        sorter.add("Count Sort");
        sorter.add("Insert Sort");
        File file = new File("src/unnamed.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    @FXML
    private int polish(){
        sortButton.setText("Sortuj");
        languageMenu.setText("Język");
        aboutMenu.setText("O programie");
        aboutMenuItem.setText("Aplikacja sluży do sortowania podanej listy przez wybrany algorytm");
        addButton.setText("Dodaj");
        text1.setText("1. Wybierz metodę sortowania");
        text2.setText("2. Dodaj element do listy (float-String)");
        text3.setText("3. Aktualna lista");
        text4.setText("4. Posortowana lista");
        text5.setText("(liczba)");
        text6.setText("(string)");
        //elementy listy
        dateFormat = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        actualDate.setText(dateFormat.format(date));
        language = 0;
        return language;
    }

    @FXML
    private int englishUS(){
        sortButton.setText("Sort");
        languageMenu.setText("Language");
        aboutMenu.setText("About");
        aboutMenuItem.setText("The aplication is used for sorting given list by chosen algorithm");
        addButton.setText("Add");
        text1.setText("1. Choose algorithm");
        text2.setText("2. Add element (float-String)");
        text3.setText("3. Unsorted list");
        text4.setText("4. Sorted lost");
        text5.setText("(number)");
        text6.setText("(string)");
        dateFormat = DateTimeFormatter.ofPattern("MM.dd.YYYY");
        actualDate.setText(dateFormat.format(date));
        language = 1;
        return language;
    }

    @FXML
    private int englishGB(){
        sortButton.setText("Sort");
        languageMenu.setText("Language");
        aboutMenu.setText("About");
        aboutMenuItem.setText("The aplication is used for sorting given list by chosen algorithm");
        addButton.setText("Add");
        text1.setText("1. Choose algorithm");
        text2.setText("2. Add element (float-String)");
        text3.setText("3. Unsorted list");
        text4.setText("4. Sorted lost");
        text5.setText("(number)");
        text6.setText("(string)");
        dateFormat = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
        actualDate.setText(dateFormat.format(date));
        language = 1;
        return language;
    }

    @FXML
    private void alertAlgorithmPL(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("Algorytm nie został wybrany");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void alertAlgorithmEN(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("Algorithm hasn't been selected");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void alertValuePL(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("Nie wprowadzono wartości do posortowania");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void alertValueEN(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("There's no value for sorting");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void alertCSPL(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("W bibliotece nie ma Count Sort dla zmiennych typu float");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void alertCSEN(){
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("!!!");
        a1.setContentText("There's no Count Sort for type float variables in the library");
        a1.setHeaderText(null);
        a1.showAndWait();
    }
    @FXML
    private void elementsEN(){
        if(messyList.size() == 1)
            elements.setText(messyList.size() + " element");
        else if(messyList.size() >= 2)
            elements.setText(String.valueOf(messyList.size()) + " elements");
        else
            elements.setText("");
    }
    @FXML
    private void elementsPL(){
        if(messyList.size() == 1)
            elements.setText(messyList.size() + " element");
        else if(messyList.size() == 2 || messyList.size() == 3 || messyList.size() == 4)
            elements.setText(String.valueOf(messyList.size()) + " elementy");
        else if(messyList.size() >= 5)
            elements.setText(messyList.size() + " elementów");
        else
            elements.setText("");
    }
}
