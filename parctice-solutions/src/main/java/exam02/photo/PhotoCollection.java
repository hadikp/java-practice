package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... photo) {
        for (String st: photo) {
            photos.add(new Photo(st));
        }
    }

    public void starPhoto(String photoName, Quality quality) {
        boolean found = true;
        for (Photo p: photos) {
            if (p.getName().equals(photoName)) {
                p.setQuality(quality);
                found = false;
            }

        }
        if (found) {
            throw new PhotoNotFoundException("Nincs ilyen foto!");
        }
    }

    public int numberOfStars() {
        int sum = 0;
        return photos.stream().mapToInt(m -> m.getQuality().getNumber()).sum(); //összesen mennyi csillag van
        /*for (Photo p: photos) {
            sum += p.getQuality().getNumber();
        }
        return sum;*/
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
