package controllers;

import classes.ParaLiczb;
import classes.Trojmian;
import play.*;
import play.mvc.*;
import play.libs.Json;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

		public static Result sayHello(String imie) {
        return ok(index.render("Hello " + imie + "!"));
    }


		public static Result compute() {
  		JsonNode json = request().body().asJson();
            ObjectNode result = Json.newObject();
			if(json == null) {
				return badRequest("Expecting Json data");
			} else {
				String a = json.findPath("a").getTextValue();
				String b = json.findPath("b").getTextValue();
				String c = json.findPath("c").getTextValue();
                double double_a;
                double double_b;
                double double_c;
				if(a == null || b == null || c == null) {
				  return badRequest("Missing parameters");
				} else {
                    double_a = Integer.parseInt(a);
                    double_b = Integer.parseInt(b);
                    double_c = Integer.parseInt(c);
                    ParaLiczb wynik = new ParaLiczb();
                    try {
                        wynik = Trojmian.licz(double_a, double_b, double_c);
                        result.put("x1", wynik.getFirst());
                        result.put("x2", wynik.getSecond());
                    } catch (Exception e){
                        result.put("ERROR", "Współczynnik a nie może być równy zeru - to nie jest trójmian");
                    }

                    return ok(result);
				}
			}
}

}
