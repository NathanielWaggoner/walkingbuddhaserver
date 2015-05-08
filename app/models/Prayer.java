package models;

import play.data.Form;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import javax.persistence.*;
/**
 * Created by nathanielwaggoner on 4/30/15.
 */
@Entity
public class Prayer extends Model {

    @Id
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String desc;
    @Constraints.Required
    public String englishText;
    public String prayerText;

    public Prayer(String prayerName, String desc, String englishText, String prayerText) {
        this.name = prayerName;
        this.desc = desc;
        this.englishText = englishText;
        this.prayerText = prayerText;
    }


    public static Finder<String,Prayer> find = new Finder<String,Prayer>(String.class,Prayer.class);

}
