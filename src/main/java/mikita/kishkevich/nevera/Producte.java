package mikita.kishkevich.nevera;

import mikita.kishkevich.Fitxers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Producte {
    //<editor-fold desc="Propietats">
    private String nom;
    private Double preu;
    private String desc;
    private String dataCaducitat;
    //</editor-fold>

    //<editor-fold desc="Fitxers">
    private static final String fitxer = ".data/productes.dat";
    private static final Fitxers file = new Fitxers(fitxer);
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Producte() {
    }

    public Producte(String nom, Double preu, String desc, String dataCaducitat) {
        this.nom = nom;
        this.preu = preu;
        this.desc = desc;
        this.dataCaducitat = dataCaducitat;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public String getNom() {
        return nom;
    }

    public Double getPreu() {
        return preu;
    }

    public String getDesc() {
        return desc;
    }

    public String getDataCaducitat() {
        return dataCaducitat;
    }
    //</editor-fold>

    public void guardarProducte() throws IOException {
        file.escriuObjecteFitxer(this,true);
    }
    public List<Producte> converteixObjProducte(List<Object> objs){
        List<Producte> productes= new ArrayList<>();
        Producte prod = new Producte();
        for (Object obj:objs) {
            prod = (Producte) obj;
            productes.add(prod);
        }
        return productes;
    }
    public List<Producte> retornarLlistaProductes(){
        List<Object> objs = file.retornaFitxerObjecteEnLlista();
        return converteixObjProducte(objs);
    }

}
