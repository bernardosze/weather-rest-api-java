package models;

import java.util.ArrayList;
import java.util.List;
import models.forecast.City;

/**
 * @author bernardosze
 */
public class Forecast {
    private int cod;
    private double message;
    private int cnt;
    private List<models.forecast.List> list = new ArrayList<models.forecast.List>();
    private City city;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<models.forecast.List> getList() {
        return list;
    }

    public void setList(List<models.forecast.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
