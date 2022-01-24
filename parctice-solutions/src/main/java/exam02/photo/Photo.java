package exam02.photo;

public class Photo implements Qualified {

    private String name;
    private Quality quality;

    public Photo(String name) {
        this.name = name;
    }

    public Photo(String name, Quality quality) {
        this(name = name);
        this.quality = quality;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }
}
