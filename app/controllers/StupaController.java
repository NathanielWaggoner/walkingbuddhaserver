package controllers;

import models.Stupa;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathanielwaggoner on 4/30/15.
 */
public class StupaController extends Controller {

    public static Result getStupas() {
        return notFound("This has not been implemented yet");
    }

    public static Form<Stupa> stupaForm = new Form<Stupa>(Stupa.class);


    public static Result stupaPage() {
        return ok(stupaPage.render(Stupa.find.all(),stupaForm));
    }

    public static Result submit() {
        Form<Stupa> filledForm= stupaForm.bindFromRequest();
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart picture = body.getFile("picture");
        if(picture!=null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();

            File file = picture.getFile();
            Stupa toSave = filledForm.get();

            toSave.stupaImagePath = file.getAbsolutePath();
            toSave.save();
            return stupaPage();
        }else {
            flash("error","Missing File");
            return redirect(routes.StupaController.stupaPage());
        }
    }
    public static Result delete(String name) {
        if(name!=null) {
            Stupa.find.byId(name).delete();
            flash("success", "Stupa deleted");
            return stupaPage();
        } else {
            return badRequest("No stupa selected");
        }
    }

    public static Result getImageForStupa(String stupaId) {
        Stupa found = Stupa.find.byId(stupaId);
        if(found!=null) {
            return ok(new File(found.stupaImagePath));
        }else {
           return badRequest("No stupa found for id: "+stupaId);
        }

    }
}
