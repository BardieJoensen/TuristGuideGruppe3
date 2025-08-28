package com.gruppe3.tourism.repository;

import com.gruppe3.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        this.touristAttractions = new ArrayList<>();
        populateAttractions();
    }

    private void populateAttractions() {
        touristAttractions.add(new TouristAttraction("ADRENALINSUS PÅ SJÆLLAND", "Er du klar til at opleve Sjælland på en helt ny måde? Denne oplevelse er skabt til den eventyrlystne sjæl, der søger spænding og udfordringer.\n" +
                "\n" +
                "Denne oplevelsesgave vil give modtageren mulighed for at udforske en masse action-fyldte oplevelser. Tag hjelmen på og mærk suset i gokarten, hvor du kan dyste mod venner eller familie. Oplev spændingen ved Indoor Skydiving, hvor du kan svæve frit og føle friheden af et faldskærmsudspring - uden at forlade byen! Eller prøv kræfter med padel, den hurtigt voksende ketchersport, der kombinerer det bedste fra tennis og squash i en sjov og dynamisk oplevelse.\n" +
                "\n" +
                "Giv dette gavekort til enhver, der søger et adrenalinkick - fra den eventyrlystne konfirmand til manden i dit liv, der ønsker at prøve noget nyt og spændende. Adrenalinsus på Sjælland er den perfekte gave til dem, der ønsker at bryde grænser og opleve livet fra en mere actionfyldt side."));
        touristAttractions.add(new TouristAttraction("PRØVEKØR DRØMMEBILEN - PORSCHE 911 CARRERA S", "Lej din drømmebil for en dag! Oplev drømmen og prøv en af verdens mest berømte biler - Porsche 911 Carrera S. Bilen er i sort metallic med sort læderindtræk og baghjulstræk ligesom en rigtig Porsche 911 skal være. Bilen er desuden udstyret med et sportsudstødningssystem for at få mere lyd i bilen og et Bose lydsystem, så du kan nyde din yndlingsmusik, mens du kører. Udover det er den også udstyret med lir i form af Porsche active suspension management, 8-trins dobbeltkoblingsboks, Apple carplay og glassoltag."));
        touristAttractions.add(new TouristAttraction("TANDEMSPRING", "DEN ULTIMATIVE OPLEVELSE MED ET ANDET MENNESKE! TAG DIN VEN ELLER KÆRESTE I HÅNDEN, SPRING UD I DET OG OPLEV SUSET I MAVEN SAMMEN. DENNE OPLEVELSE VIL UDEN TVIVL KNYTTE BÅND FOR LIVET.\n" +
                "\n" +
                "Vores professionelle og specialuddannede instruktører vil guide jer til at udfordre egne grænser i sikre rammer.\n" +
                "\n" +
                "Et tandemspring er den perfekte anledning til at komme hinanden ved, idet at i fastspændes i hver jeres bodyharness, og tager springet sammen."));
        touristAttractions.add(new TouristAttraction("Storkespringvandet", "Flamingoer der springer i vand"));
    }

    public List<TouristAttraction> getAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        touristAttractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        TouristAttraction oldAttraction = findAttractionByName(attraction.getName());
        if (oldAttraction != null) {
            oldAttraction.setDescription(attraction.getDescription());
            return oldAttraction;
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction attraction = findAttractionByName(name);
        if (attraction != null) {
            touristAttractions.remove(attraction);
            return attraction;
        }
        return null;
    }
}
