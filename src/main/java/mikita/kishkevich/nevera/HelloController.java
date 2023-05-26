package mikita.kishkevich.nevera;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Tab TABEntrada;
    @FXML
    private Button IN_BTNGuardar;
    @FXML
    private Label IN_LBLNom_Show;
    @FXML
    private Label IN_LBLPreu_Show;
    @FXML
    private Label IN_LBLDesc_Show;
    @FXML
    private Label IN_LBLDataCaducitat_Show;
    @FXML
    private Label IN_LBLNom;
    @FXML
    private Label IN_LBLPreu;
    @FXML
    private Label IN_LBLDesc;
    @FXML
    private Label IN_LBLDataCaducitat;
    @FXML
    private TextField IN_TFNom;
    @FXML
    private TextField IN_TFPreu;
    @FXML
    private TextArea IN_TADesc;
    @FXML
    private DatePicker IN_DPDataCaducitat;
    @FXML
    private Tab TABSortida;
    @FXML
    private Button OUT_BTNTreure;
    @FXML
    private Label OUT_LBLNom_Show;
    @FXML
    private Label OUT_LBLPreu_Show;
    @FXML
    private Label OUT_LBLDesc_Show;
    @FXML
    private Label OUT_LBLDataCaducitat_Show;
    @FXML
    private Button OUT_BTNFirst;
    @FXML
    private Button OUT_BTNPrev;
    @FXML
    private Button OUT_BTNNext;
    @FXML
    private Button OUT_BTNLast;
    @FXML
    private Label OUT_LBLNom;
    @FXML
    private Label OUT_LBLPreu;
    @FXML
    private Label OUT_LBLDesc;
    @FXML
    private Label OUT_LBLDataCaducitat;
    @FXML
    private TextField OUT_TFNom;
    @FXML
    private TextField OUT_TFPreu;
    @FXML
    private TextArea OUT_TADesc;
    @FXML
    private DatePicker OUT_DPDataCaducitat;
    @FXML
    private Button OUT_BTNTreure1;

    static Producte p = new Producte();
    static int index = 0;
    static List<Producte> productesCerca = new ArrayList<>();

    /**
     * Metode que s'executa al executar el programa per primer cop
     */
    public void initialize(){
        mostrarINLBLShow(false);
        mostrarOUTLBLShow(false);
        comprovarBotons();
    }


    /**
     * Metode per mostrar o no els Labels del producte afegit
     * @param mostrar boolea que per mostrar els labels
     */
    public void mostrarINLBLShow(boolean mostrar){
        IN_LBLNom_Show.setVisible(mostrar);
        IN_LBLPreu_Show.setVisible(mostrar);
        IN_LBLDesc_Show.setVisible(mostrar);
        IN_LBLDataCaducitat_Show.setVisible(mostrar);
    }

    /**
     *  Metode per mostrar o no els Labels del producte cercat
     * @param mostrar boolea que per mostrar els labels
     */
    public void mostrarOUTLBLShow(boolean mostrar){
        OUT_LBLNom_Show.setVisible(mostrar);
        OUT_LBLPreu_Show.setVisible(mostrar);
        OUT_LBLDesc_Show.setVisible(mostrar);
        OUT_LBLDataCaducitat_Show.setVisible(mostrar);
    }

    /**
     *  metode per amagar els labels quan canviem de pestanya
     */
    public void canviaSortida(){
        mostrarINLBLShow(false);
    }

    /**
     * metode per amagar els labels quan canviem de pestanya
     */
    public void canviaEntrada(){
        mostrarOUTLBLShow(false);
    }

    /**
     *  metode per guardar el producte en la pestanya d'entrada
     * @throws IOException
     */
    public void guardarProducte() throws IOException {
        String nom = IN_TFNom.getText();
        Double preu = Double.parseDouble(IN_TFPreu.getText());
        String desc = IN_TADesc.getText();
        LocalDate dataCaducitat = IN_DPDataCaducitat.getValue();
        IN_LBLNom_Show.setText(IN_TFNom.getText());
        IN_LBLPreu_Show.setText(IN_TFPreu.getText());
        IN_LBLDesc_Show.setText(IN_TADesc.getText());
        IN_LBLDataCaducitat_Show.setText(IN_DPDataCaducitat.getValue().toString());
        mostrarINLBLShow(true);
        Producte prod = new Producte(nom, preu, desc, dataCaducitat);
        System.out.println(prod.toString());
        prod.guardarProducte();
    }

    /**
     * metode per cercar productes segons els parametres introduits
     */
    public void cercarProducte(){
        index = 0;
        List<Producte> productesNom = p.retornarLlistaProductes();
        productesCerca = p.retornarLlistaProductes();
        int j = 0;
        if(OUT_TFNom.getText().length()>0){
            for (int i = 0; i < productesNom.size(); i++) {
                if(!productesNom.get(i).getNom().equals(OUT_TFNom.getText())) {
                    productesCerca.remove(j);
                    j--;
                }
                j++;
            }
        }

        if(OUT_TFPreu.getText().length()>0){
            j = 0;
            List<Producte> productesPreu = new ArrayList<>(productesCerca);
            for (int i = 0; i < productesPreu.size(); i++) {
                if(!(productesPreu.get(i).getPreu() == Double.parseDouble(OUT_TFPreu.getText()))) {
                    productesCerca.remove(j);
                    j--;
                }
                j++;
            }
        }

        if(OUT_TADesc.getText().length()>0){
            j = 0;
            List<Producte> productesDesc = new ArrayList<>(productesCerca);
            for (int i = 0; i < productesDesc.size(); i++) {
                if(!(productesDesc.get(i).getDesc().equals(OUT_TADesc.getText()))) {
                    productesCerca.remove(j);
                    j--;
                }
                j++;
            }
        }

        if(OUT_DPDataCaducitat.getValue() != null){
            j = 0;
            List<Producte> productesData = new ArrayList<>(productesCerca);
            for (int i = 0; i < productesData.size(); i++) {
                if(!(productesData.get(i).getDataCaducitat().equals(OUT_DPDataCaducitat.getValue()))) {
                    productesCerca.remove(j);
                    j--;
                }
                j++;
            }
        }


        if (productesCerca.size() > 0){
            mostrarOUTLBLShow(true);
            setTextOUTShow();
        }else{
            mostrarOUTLBLShow(false);
        }

        comprovarBotons();
    }

    /**
     * metode per posar el producte de la llista resultat de cerca segons l'index
     */
    public void setTextOUTShow(){
        OUT_LBLNom_Show.setText(productesCerca.get(index).getNom());
        OUT_LBLPreu_Show.setText(String.valueOf(productesCerca.get(index).getPreu()));
        OUT_LBLDesc_Show.setText(productesCerca.get(index).getDesc());
        OUT_LBLDataCaducitat_Show.setText(productesCerca.get(index).getDataCaducitat().toString());
    }

    /**
     * metode per mostrar el seguent producte de la llista
     */
    public void seguentLlista(){
        index++;
        setTextOUTShow();
        comprovarBotons();
    }

    /**
     * metode per mostrar l'anterior producte de la llista
     */
    public void anteriorLlista(){
        index--;
        setTextOUTShow();
        comprovarBotons();
    }

    /**
     * metode per mostrar el primer producte de la llista
     */
    public void primerLlista(){
        index = 0;
        setTextOUTShow();
        comprovarBotons();
    }

    /**
     * metode per mostrar l'ultim producte de la llista
     */
    public void ultimLlista(){
        index = productesCerca.size() - 1;
        setTextOUTShow();
        comprovarBotons();
    }

    /**
     * metode per borrar el producte de l'arxiu i de la llista de cerca
     * @throws IOException
     */
    public void treureProducte() throws IOException {
        List<Producte> productesFinals = p.retornarLlistaProductes();
        productesFinals.remove(productesCerca.get(index));
        if(productesCerca.size() == 1) {
            productesCerca.remove(index);
            mostrarOUTLBLShow(false);
        }else{
            productesCerca.remove(index);
            index = 0;
            setTextOUTShow();
        }
        p.guardarLlistaProductes(productesFinals);
        comprovarBotons();

    }

    /**
     * metode per comprovar quins botons s'han de mostrar segons
     * els productes que tenim en la llista
     */
    public void comprovarBotons(){
        if(index > 0){
            OUT_BTNFirst.setVisible(true);
            OUT_BTNPrev.setVisible(true);
        }else{
            OUT_BTNFirst.setVisible(false);
            OUT_BTNPrev.setVisible(false);
            OUT_BTNLast.setVisible(true);
        }
        if (index < productesCerca.size() - 1){
            OUT_BTNLast.setVisible(true);
            OUT_BTNNext.setVisible(true);
        }else{
            OUT_BTNLast.setVisible(false);
            OUT_BTNNext.setVisible(false);
            OUT_BTNFirst.setVisible(index != 0);
        }
        OUT_BTNTreure.setVisible(productesCerca.size() > 0);
    }




    


}