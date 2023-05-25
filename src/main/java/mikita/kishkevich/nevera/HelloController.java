package mikita.kishkevich.nevera;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private Tab TABEntrada;
    @FXML
    private Button INBTNGuardar;
    @FXML
    private Label INLBLNomShow;
    @FXML
    private Label INLBLPreuShow;
    @FXML
    private Label INLBLDescShow;
    @FXML
    private Label INLBLDataCaducitatShow;
    @FXML
    private Label INLBLNom;
    @FXML
    private Label INLBLPreu;
    @FXML
    private Label INLBLDesc;
    @FXML
    private Label INLBLDataCaducitat;
    @FXML
    private TextField INTFNom;
    @FXML
    private TextField INTFPreu;
    @FXML
    private TextArea INTADesc;
    @FXML
    private DatePicker INDPDataCaducitat;
    @FXML
    private Tab TABSortida;
    @FXML
    private Button OUTBTNTreure;
    @FXML
    private Label OUTLBLNomShow;
    @FXML
    private Label OUTLBLPreuShow;
    @FXML
    private Label OUTLBLDescShow;
    @FXML
    private Label OUTLBLDataCaducitatShow;
    @FXML
    private Button OUTBTNFirst;
    @FXML
    private Button OUTBTNPrev;
    @FXML
    private Button OUTBTNNext;
    @FXML
    private Button OUTBTNLast;
    @FXML
    private Label OUTLBLNom;
    @FXML
    private Label OUTLBLPreu;
    @FXML
    private Label OUTLBLDesc;
    @FXML
    private Label OUTLBLDataCaducitat;
    @FXML
    private TextField OUTTFNom;
    @FXML
    private TextField OUTTFPreu;
    @FXML
    private TextArea OUTTADesc;
    @FXML
    private DatePicker OUTDPDataCaducitat;
    @FXML
    private Button OUTBTNTreure1;

    public void initialize(){
        INLBLNomShow.setVisible(false);
        INLBLPreuShow.setVisible(false);
        INLBLDescShow.setVisible(false);
        INLBLDataCaducitatShow.setVisible(false);
        OUTLBLNomShow.setVisible(false);
        OUTLBLPreuShow.setVisible(false);
        OUTLBLDescShow.setVisible(false);
        OUTLBLDataCaducitatShow.setVisible(false);
    }

    public void canviaSortida(){
        INLBLNomShow.setVisible(false);
        INLBLPreuShow.setVisible(false);
        INLBLDescShow.setVisible(false);
        INLBLDataCaducitatShow.setVisible(false);
    }

    public void canviaEntrada(){
        OUTLBLNomShow.setVisible(false);
        OUTLBLPreuShow.setVisible(false);
        OUTLBLDescShow.setVisible(false);
        OUTLBLDataCaducitatShow.setVisible(false);
    }

    public void guardarProducte(){
        String nom = INTFNom.getText();
        Double preu = Double.parseDouble(INTFPreu.getText());
        String desc = INTADesc.getText();
        LocalDate dataCaducitat = INDPDataCaducitat.getValue();
        INLBLNomShow.setText(INTFNom.getText());
        INLBLPreuShow.setText(INTFPreu.getText());
        INLBLDescShow.setText(INTADesc.getText());
        INLBLDataCaducitatShow.setText(INDPDataCaducitat.getValue().toString());
        INLBLNomShow.setVisible(true);
        INLBLPreuShow.setVisible(true);
        INLBLDescShow.setVisible(true);
        INLBLDataCaducitatShow.setVisible(true);
    }
    


}