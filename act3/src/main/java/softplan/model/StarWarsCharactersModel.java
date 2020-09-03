package softplan.model;

public class StarWarsCharactersModel {

    private static String urlAddress = "https://swapi.dev/api/people/?search=";;
    private String output;

    public static String getUrlAddress() {
        return urlAddress;
    }

    public String getOutput() {
        return output;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
