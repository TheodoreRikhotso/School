/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author rikho
 */
public class Engine {

    private List<Car> carList;

    public Engine() {
    }

    public Engine(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> searchSubCar() {
        List<Car> urls = new ArrayList<>();

        for (Car car : this.carList) {
            Document doc;

            try {

                doc = Jsoup.connect(car.getCar()).get();

                List<String> carTitle = new ArrayList<>();
                List<String> carPrice = new ArrayList<>();
                ArrayList<String> carMileage = new ArrayList<>();
                List<String> carContact = new ArrayList<>();
                Elements elements = doc.select("div.card-content > span.car-title");
                for (Element e : elements) {
                    carTitle.add(e.text());
                }
                Elements element = doc.select("div.card-content > span.car-mileage");
                int t = 0;

                for (Element e : element) {
                    carMileage.add(e.text());
                }

                Elements carPriceElements = doc.select("div.card-content > span.car-price");
                for (Element e : carPriceElements) {
                    carPrice.add(e.text());
                }

                for (int i = 0; i < carTitle.size(); i++) {
                    System.out.println(" ============================================= ");
                    System.out.println("         Name " + carTitle.get(i));
                    System.out.println("         Price " + carPrice.get(i));
                    System.out.println("         Mileage " + carMileage.get(i));
                    System.out.println(" ============================================= ");
                }

            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());

            }
        }
        return urls;
    }

    public List<PageContent> searchSubCarContent(String name) {
        List<PageContent> pages = new ArrayList<>();

        List<Car> cars = this.searchSubCar();

        for (Car car : cars) {
            Document doc;

            try {
                doc = Jsoup.connect(car.getCar()).get();

                String tittle = doc.title();
                String content = doc.body().text();

                pages.add(new PageContent(car.getCar(), tittle, content));

            } catch (IllegalArgumentException ae) {
                System.out.println("Error " + ae.getMessage());
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }

        }
        return pages;
    }

    public void searchCars(String name ) {
        List<Car> urls = new ArrayList<>();
        List<String> result=new ArrayList<>();
        for (Car car : this.carList) {
            Document doc;

            try {

                doc = Jsoup.connect(car.getCar()).get();

                List<String> carTitle = new ArrayList<>();
                List<String> carPrice = new ArrayList<>();
                ArrayList<String> carMileage = new ArrayList<>();
                List<String> carContact = new ArrayList<>();
                Elements elements = doc.select("div.card-content > span.car-title");
                for (Element e : elements) {
                    carTitle.add(e.text());
                }
                Elements element = doc.select("div.card-content > span.car-mileage");
                int t = 0;

                for (Element e : element) {
                    carMileage.add(e.text());
                }

                Elements carPriceElements = doc.select("div.card-content > span.car-price");
                for (Element e : carPriceElements) {
                    carPrice.add(e.text());
                }
                
                int y = 0;
                 for (int i = 0; i < carTitle.size(); i++) {
                     if(carTitle.get(i).contains(name)){
                         y++;
                          System.out.println(" ============================================= ");
                            System.out.println("         Name " + carTitle.get(i));
                            System.out.println("         Price " + carPrice.get(i));
                            System.out.println("         Mileage " + carMileage.get(i));
                            System.out.println(" ============================================= ");
                     }
                     
                     
                 }
                if(y==0){
                    System.out.println("Car not found!");
                }

            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());

            }
        }
       
        
        }    

    

    

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

}
