package exp.doselect;

import java.util.*;

class MobileProblemSolution {
}

class Mobile {
    HashMap<String, ArrayList<String>> mobiles = new HashMap<>();

    public String addModel(String company, String model) {
        if (!mobiles.containsKey(company)) {
            ArrayList<String> models = new ArrayList<>();
            mobiles.put(company, models);
        }
        ArrayList<String> models = mobiles.get(company);
        models.add(model);
        return "model successfully added";
    }

    public ArrayList<String> getModel(String company) {
        if (!mobiles.containsKey(company)) {
           return null;
        }
        ArrayList<String>models = mobiles.get(company);
        if(models.isEmpty()){
            return null;
        }
        return models;
    }

    public String buyMobile(String company, String model) {
        if (!mobiles.containsKey(company)) {
            return "item not available";
        }
        ArrayList<String> models = mobiles.get(company);
        if (!models.contains(model)) {
            return "item not available";
        }
        mobiles.remove(model);
        return "mobile sold successfully";
    }

}
