package com.recipefinder;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import java.io.IOException;

public class RecipeFinderController {
    Recipe[] recipeList;
    TitledPane[] titledPanes;
    TextArea[] textAreas;

    @FXML
    private TextField searchQueryTextField;
    @FXML
    private TitledPane accordionPane1, accordionPane2, accordionPane3, accordionPane4, accordionPane5, accordionPane6, accordionPane7, accordionPane8, accordionPane9, accordionPane10;
    @FXML
    private TextArea accordionText1, accordionText2, accordionText3, accordionText4, accordionText5, accordionText6, accordionText7, accordionText8, accordionText9, accordionText10;

    @FXML
    private void initialize() {
        titledPanes = new TitledPane[]{accordionPane1, accordionPane2, accordionPane3, accordionPane4, accordionPane5, accordionPane6, accordionPane7, accordionPane8, accordionPane9, accordionPane10};
        textAreas = new TextArea[]{accordionText1, accordionText2, accordionText3, accordionText4, accordionText5, accordionText6, accordionText7, accordionText8, accordionText9, accordionText10};
    }

    @FXML
    protected void onSearchButtonClick() throws IOException, InterruptedException {
        int i = 0;

        String query = searchQueryTextField.getText();
        recipeList = com.recipefinder.GetApiResponse.getJsonArray(query);

        for (TitledPane p : titledPanes) {
            p.setText(recipeList[i].title());
            i++;
        }
        i = 0;
        for (TextArea a : textAreas) {
            a.setText(recipeList[i].toString());
            i++;
        }
    }

    @FXML
    public void searchQueryTextFieldKeyHandler(javafx.scene.input.KeyEvent keyEvent) throws IOException, InterruptedException {
        if (keyEvent.getCode() == KeyCode.ENTER)
            onSearchButtonClick();
    }

}

