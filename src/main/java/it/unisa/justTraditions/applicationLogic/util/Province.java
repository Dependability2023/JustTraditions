package it.unisa.justTraditions.applicationLogic.util;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public abstract class Province {

  private static final List<String> province = List.of(
      "Agrigento",
      "Alessandria",
      "Ancona",
      "Aosta",
      "Arezzo",
      "Ascoli Piceno",
      "Asti",
      "Avellino",
      "Bari",
      "Barletta-Andria-Trani",
      "Belluno",
      "Benevento",
      "Bergamo",
      "Biella",
      "Bologna",
      "Bolzano",
      "Brescia",
      "Brindisi",
      "Cagliari",
      "Caltanissetta",
      "Campobasso",
      "Caserta",
      "Catania",
      "Catanzaro",
      "Chieti",
      "Como",
      "Cosenza",
      "Cremona",
      "Crotone",
      "Cuneo",
      "Enna",
      "Fermo",
      "Ferrara",
      "Firenze",
      "Foggia",
      "Forlì-Cesena",
      "Frosinone",
      "Genova",
      "Gorizia",
      "Grosseto",
      "Imperia",
      "Isernia",
      "L’aquila",
      "La spezia",
      "Latina",
      "Lecce",
      "Lecco",
      "Livorno",
      "Lodi",
      "Lucca",
      "Macerata",
      "Mantova",
      "Massa-Carrara",
      "Matera",
      "Messina",
      "Milano",
      "Modena",
      "Monza e Brianza",
      "Napoli",
      "Novara",
      "Nuoro",
      "Oristano",
      "Padova",
      "Palermo",
      "Parma",
      "Pavia",
      "Perugia",
      "Pesaro e Urbino",
      "Pescara",
      "Piacenza",
      "Pisa",
      "Pistoia",
      "Pordenone",
      "Potenza",
      "Prato",
      "Ragusa",
      "Ravenna",
      "Reggio Calabria",
      "Reggio Emilia",
      "Rieti",
      "Rimini",
      "Roma",
      "Rovigo",
      "Salerno",
      "Sassari",
      "Savona",
      "Siena",
      "Siracusa",
      "Sondrio",
      "Sud Sardegna",
      "Taranto",
      "Teramo",
      "Terni",
      "Torino",
      "Trapani",
      "Trento",
      "Treviso",
      "Trieste",
      "Udine",
      "Varese",
      "Venezia",
      "Verbano-Cusio-Ossola",
      "Vercelli",
      "Vibo valentia",
      "Vicenza",
      "Verona",
      "Viterbo"
  );

  @ModelAttribute("province")
  public static List<String> getProvince() {
    return province;
  }
}
