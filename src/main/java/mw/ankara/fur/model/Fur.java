package mw.ankara.fur.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fur {

    private int id;
    private String name;
    private String thumb;
    private String origin;
    private String date;
    private String time;

    public Fur() {
    }

    public Fur(String name, String thumb, String origin) {
        this.name = name;
        this.thumb = thumb;
        this.origin = origin;

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat();

        format.applyPattern("yyyy-MM-dd");
        this.date = format.format(date);
        format.applyPattern("HH:mm:dd");
        this.time = format.format(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
