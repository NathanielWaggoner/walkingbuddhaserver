package controllers;

import models.User;
import play.*;
import play.mvc.*;

import views.html.*;

import play.data.*;
import models.*;

import java.util.List;

public class Application extends Controller {

    public static class Login {

        public String email;
        public String password;

        public String validate() {
            System.out.println(email);
            System.out.println(password);
            if(User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    /**
     * Login page.
     */
    public static Result login() {
        List<User> users = User.findAll();
        for(User user: users) {
            System.out.println("user "+user.name+" email: "+user.email+ " pass: "+user.password);
        }
        if(users.size()==0) {
            System.out.println("no users");
        }
        return ok(
                login.render(Form.form(Login.class))
        );
    }

    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            System.out.println("Failed auth");
            return badRequest(login.render(loginForm));
        } else {
            System.out.println("succeeded auth");
            session("email", loginForm.get().email);
            return redirect(
                    routes.Application.index()
            );
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Application.login()
        );
    }


    public static Result index() {
        return ok(index.render());
    }


//    public static Result javascriptRoutes() {
//        response().setContentType("text/javascript");
//        return ok(
//                Routes.javascriptRouter("jsRoutes",
//
//                        // Routes for Projects
//                        controllers.routes.javascript.Projects.add(),
//                        controllers.routes.javascript.Projects.delete(),
//                        controllers.routes.javascript.Projects.rename(),
//                        controllers.routes.javascript.Projects.addGroup(),
//                        controllers.routes.javascript.Projects.deleteGroup(),
//                        controllers.routes.javascript.Projects.renameGroup(),
//                        controllers.routes.javascript.Projects.addUser(),
//                        controllers.routes.javascript.Projects.removeUser(),
//
//                        // Routes for Tasks
//                        controllers.routes.javascript.Tasks.addFolder(),
//                        controllers.routes.javascript.Tasks.renameFolder(),
//                        controllers.routes.javascript.Tasks.deleteFolder(),
//                        controllers.routes.javascript.Tasks.index(),
//                        controllers.routes.javascript.Tasks.add(),
//                        controllers.routes.javascript.Tasks.update(),
//                        controllers.routes.javascript.Tasks.delete()
//                )
//        );
//    }

}
