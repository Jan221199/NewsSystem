package newssystem.model;

public class News {
    private String headline;
    private String category;

    public News(String headline, String category) {
        this.headline = headline;
        this.category = category;
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
