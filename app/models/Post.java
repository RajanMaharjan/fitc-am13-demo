package models;

public class Post {
    public String title;
    public String image_url;
    public String location;

    public Post(String title, String image_url, String location) {
        this.title = title;
        this.image_url = image_url;
        this.location = location;
    }
}

