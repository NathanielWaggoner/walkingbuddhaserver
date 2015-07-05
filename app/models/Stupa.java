package models;

import javax.persistence.*;
import play.db.ebean.*;

import java.io.File;

/**
 * Created by nathanielwaggoner on 4/30/15.
 */
@Entity
public class Stupa extends Model {

    @Id
    public String stupaName;
    public String descritpion;
    public String latitude;
    public String longitude;
    public String stupaImagePath;
    public String stupaVideoPath;

    public Stupa(String stupaName, String descritpion, String latitude, String longitude, String stupaImagePath,String stupaVideoPath) {
        this.stupaName = stupaName;
        this.descritpion = descritpion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stupaImagePath = stupaImagePath;
        this.stupaVideoPath = stupaVideoPath;
    }

    public static Finder<String,Stupa> find = new Finder<String, Stupa>(String.class, Stupa.class);
}
