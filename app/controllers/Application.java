package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import models.Post;
import play.libs.Json;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result posts() {
        ArrayList<Post> posts = new ArrayList<Post>();
        posts.add(new Post("Anemony in the night", "anemony.jpg", "Phuket, Thailand"));
        posts.add(new Post("I almost touched this grumpy scorpionfish!", "scorpionfish.jpg", ""));
        posts.add(new Post("Don't move! It will sting just a bit...", "lionfish.jpg", ""));
        posts.add(new Post("Dating back to pre-historic times", "nautilus.jpg", ""));
        posts.add(new Post("A shy Purple Leaf...", "purple-leaf.jpg", ""));
        posts.add(new Post("Will you be so calm in front of an alien?", "process.jpg", ""));

        return ok(Json.toJson(posts));
    }
}
