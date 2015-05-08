import controllers.Application;

import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;


/**
 * Created by nathanielwaggoner on 4/30/15.
 */
public class Global extends GlobalSettings {


    @Override
    public void onStart(play.Application app) {
        if(Prayer.find.findRowCount() == 0) {
            Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
            Ebean.save(all.get("prayers"));
        }
    }
}
