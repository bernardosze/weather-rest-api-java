package services;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 * @author bernardosze
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        
        Set<Class<?>> resources = new HashSet<>();
        
            resources.add(services.WeatherService.class);
            
        return resources;
    }
}
