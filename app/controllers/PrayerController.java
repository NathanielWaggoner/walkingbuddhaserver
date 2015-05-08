package controllers;

import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import models.Prayer;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
/**
 * Created by nathanielwaggoner on 4/30/15.
 */
public class PrayerController extends Controller {

    public static Form<Prayer> prayerForm = Form.form(Prayer.class);

    public static Result getPrayers() {
        return notFound("This has not been implemented yet");
    };

    public static Result prayerPage() {
        return ok(prayerPage.render(Prayer.find.all(), prayerForm));
    }

    public static Result submit(){

        Form<Prayer> filledForm= prayerForm.bindFromRequest();
        if(filledForm.field("prayerName").toString().length()==0) {
            filledForm.reject("You must filled out a prayer name");
        }

        if(filledForm.hasErrors()) {
            return badRequest(prayerPage.render(Prayer.find.all(), prayerForm));
        } else {
            Prayer created = filledForm.get();
            created.save();
            return prayerPage();
        }
    }

    public static Result delete(String name) {
        if(name!=null) {
            Prayer.find.byId(name).delete();
            flash("success", "Prayer deleted");
            return prayerPage();
        } else {
            return badRequest("No prayer selected");
        }
    }

}
