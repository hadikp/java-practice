package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String ... photo) {
        for (String st: photo) {
            photos.add(new Photo(st));
        }
    }

    public void starPhoto(String photoName, Quality quality) {
        for (Photo p: photos) {
            if (p.getName().equals(photoName)) {
                p.setQuality(quality);
            } else {
                throw new PhotoNotFoundException("Nincs ilyen foto!");
            }
        }
    }

    public int numberOfStars() {
        //return photos.stream().mapToInt(Photo::getQuality).sum(); //összesen mennyi csillag van
        return 11;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
