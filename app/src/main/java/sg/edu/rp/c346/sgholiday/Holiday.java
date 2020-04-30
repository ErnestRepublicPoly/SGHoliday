package sg.edu.rp.c346.sgholiday;

public class Holiday {
    private String name;
    private String day;
    private int image;
    public Holiday(String name, String day, int image) {
        this.name = name;
        this.day = day;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }
}

