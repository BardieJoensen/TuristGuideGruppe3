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
        touristAttractions.add(new TouristAttraction("Vertigo", "Svingarme drejer rundt hurtigt / Plane goes brrrr "));
        touristAttractions.add(new TouristAttraction("Hurlumhejhuset", "Et hus på Bakken der er skaevt tror jeg? "));
        touristAttractions.add(new TouristAttraction("Rundetaarn", "Et firkantet taarn i København eller et noget"));
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
