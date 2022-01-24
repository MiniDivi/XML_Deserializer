package it.divincenzo;


import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
    public static void main(String[] args) throws IOException {

        /* Deserializzazione */

        File file = new File("src/main/resources/classe.xml");
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);
        System.out.println("La classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'aula "
                + value.getAula().getNome() + " ed è composta dai seguenti studenti: ");

        for (int i = 0; i < value.getStudenti().size(); i++) {
            System.out.println("- " + value.getStudenti().get(i).getCognome());

        }

        /* Serializzazione */

            xmlMapper.writeValue(new File("src/main/resources/classe_serializzata.xml"), value);
            File XMLFile = new File("classe_serializzata.xml");
    }
}
