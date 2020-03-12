package newssystem.model;

import java.util.UUID;

public class News {
    private String id;
    private String headline;
    private String category;

    public News(String headline, String category) {
        this.id = UUID.randomUUID().toString();
        this.headline = headline;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return getHeadline();
    }
}
