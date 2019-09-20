package services;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import models.Forecast;
import models.WeatherReport;

/**
 * @author bernardosze
 */
@Path("weather")
@Produces("application/json")
public class WeatherService {
    @GET
    @Path("getweather")
    public String getWeather(@QueryParam("lat") String latitude, @QueryParam("lon") String longitude) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=909e855e935e504c9052160b85795283&units=metric");
        
        Invocation.Builder request = resource.request();
        
        Response response = request.get();
        
        if(response.getStatus() == 200) {
            String output = response.readEntity(String.class);
            
            Gson gson = new Gson();
            WeatherReport weather = gson.fromJson(output, WeatherReport.class);
            return gson.toJson(weather);
        }
        return null;       
    }
    
    @GET
    @Path("getweatherbycity")
    public String getWeatherByCity(@QueryParam("q") String city) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=909e855e935e504c9052160b85795283&units=metric");
        
        Invocation.Builder request = resource.request();
        
        Response response = request.get();
        
        if(response.getStatus() == 200) {
            String output = response.readEntity(String.class);
            
            Gson gson = new Gson();
            WeatherReport weather = gson.fromJson(output, WeatherReport.class);
            return gson.toJson(weather);
        }
        return null;       
    }
    
    @GET
    @Path("getforecast")
    public String getForecast(@QueryParam("lat") String latitude, @QueryParam("lon") String longitude) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target("https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude + "&appid=909e855e935e504c9052160b85795283&units=metric");
        
        Invocation.Builder request = resource.request();
        
        Response response = request.get();
        
        if(response.getStatus() == 200) {
            String output = response.readEntity(String.class);
            
            Gson gson = new Gson();
            Forecast forecast = gson.fromJson(output, Forecast.class);
            return gson.toJson(forecast);
        }
        return null;       
    }
    
    @GET
    @Path("test")
    public String test() {
        return "Test Successful!";
    }
}
