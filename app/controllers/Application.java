package controllers;

import classes.Lobuzy;
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

    public static Result cyfrokrad() {
        JsonNode json = request().body().asJson();
        ObjectNode return_result = Json.newObject();
        Integer result, number;
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String numberString = json.findPath("number").getTextValue();

            if(numberString == null) {
                return badRequest("Missing parameters");
            } else {
                number = Integer.parseInt(numberString);
                try {
                    result = Lobuzy.cyfrokrad(number);
                    return_result.put("result", result);

                } catch (Exception e){
                    return_result.put("ERROR", "Parsing Error");
                }

                return ok(return_result);
            }
        }
    }

    public static Result hultajchochla() {
        JsonNode json = request().body().asJson();
        ObjectNode return_result = Json.newObject();
        Integer result, number;
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String numberString = json.findPath("number").getTextValue();

            if(numberString == null) {
                return badRequest("Missing parameters");
            } else {
                number = Integer.parseInt(numberString);
                try {
                    result = Lobuzy.hultajchochla(number);
                    return_result.put("result", result);

                } catch (Exception e){
                    return_result.put("ERROR", "Parsing Error");
                }

                return ok(return_result);
            }
        }
    }

    public static Result nieksztaltek() {
        JsonNode json = request().body().asJson();
        ObjectNode return_result = Json.newObject();
        Integer result, number;
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String numberString = json.findPath("number").getTextValue();

            if(numberString == null) {
                return badRequest("Missing parameters");
            } else {
                number = Integer.parseInt(numberString);
                try {
                    result = Lobuzy.nieksztaltek(number);
                    return_result.put("result", result);

                } catch (Exception e){
                    return_result.put("ERROR", "Parsing Error");
                }

                return ok(return_result);
            }
        }
    }

    public static Result prime() {
        JsonNode json = request().body().asJson();
        ObjectNode return_result = Json.newObject();
        Integer result, number;
        int k=0;
        int prime =0;
        int i;
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String numberString = json.findPath("number").getTextValue();

            if(numberString == null) {
                return badRequest("Missing parameters");
            } else {
                number = Integer.parseInt(numberString);
                try {
                   for (i=0; i< number; i++) {
                       if (isPrime(i)) {
                        prime = i;
                       }
                   }
                    return_result.put("result", prime);

                } catch (Exception e){
                    return_result.put("ERROR", "Parsing Error");
                }

                return ok(return_result);
            }
        }
    }


    public static boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }



}
