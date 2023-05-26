package mikita.kishkevich.nevera;

import mikita.kishkevich.Fitxers;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Producte implements Serializable {
    //<editor-fold desc="Propietats">
    private int id;
    private String nom;
    private Double preu;
    private String desc;
    private LocalDate dataCaducitat;
    //</editor-fold>

    //<editor-fold desc="Fitxers">
    private static final String fitxerCSV = ".data/productes.csv";
    private static final String fitxerDAT = ".data/productes.dat";
    private static final Fitxers file = new Fitxers(fitxerDAT);
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Producte() {
    }

    public Producte(String nom, Double preu, String desc, LocalDate dataCaducitat) {
        // id unic per objecte
        this.id = System.identityHashCode(this);
        // resta de parametres
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

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Producte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", desc='" + desc + '\'' +
                ", dataCaducitat=" + dataCaducitat +
                '}';
    }

    /**
     *
     * @throws IOException
     */
    public void guardarProducte() throws IOException {
        guardarProducte(true);
    }

    /**
     *
     * @param afegir
     * @throws IOException
     * @see Fitxers
     */
    public void guardarProducte(boolean afegir) throws IOException {
        file.escriuObjecteFitxer(this,afegir);
    }

    /**
     *
     * @param productes
     * @throws IOException
     */
    public void guardarLlistaProductes(List<Producte> productes) throws IOException {
        for (Producte prod: productes) {
            if (prod == productes.get(0)){
                guardarProducte(false);
            }else{
                guardarProducte();
            }
        }
    }

    /**
     * @author mikita.kishkevich
     * @param objs
     * @return
     * @since 1.0
     */
    public List<Producte> converteixObjProducte(List<Object> objs){
        List<Producte> productes= new ArrayList<>();
        Producte prod = new Producte();
        for (Object obj:objs) {
            prod = (Producte) obj;
            productes.add(prod);
        }
        return productes;
    }

    /**
     *
     * @return
     * @see Fitxers
     */
    public List<Producte> retornarLlistaProductes(){
        List<Object> objs = file.retornaFitxerObjecteEnLlista();
        return converteixObjProducte(objs);
    }

    /**
     *
     * @throws IOException
     * @Deprecated
     */
    public void convertirCSVaBinari() throws IOException {
        String text = file.retornaFitxerTextNIO();
        String []linies = text.split("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0; i < linies.length; i++) {
            String []param = linies[i].split(";");
            String nom = param[0];
            Double preu = Double.parseDouble(param[1]);
            String desc = param[2];
            LocalDate dataCaducitat = LocalDate.parse(param[3],formatter);
            Producte prod = new Producte(nom, preu, desc, dataCaducitat);
            file.escriuObjecteFitxer(prod, true);
        }
    }



}
