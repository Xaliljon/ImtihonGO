package uz.peachdev.imtihongo.Model;

public class Model {
    //Model class
    String name;
    String imageUrl;
    String desc;
    String time;


//Constructors:

    public Model() {
    }

    public Model(String name, String imageUrl, String desc, String time) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.desc = desc;
        this.time = time;

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
