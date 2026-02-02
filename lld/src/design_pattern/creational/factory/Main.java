package design_pattern.creational.factory;

interface Logistic{
    void send();
}

class RoadLogistic implements Logistic {
    @Override
    public void send() {
        System.out.println("RoadLogistic send");
    }
}

class AirLogistic implements Logistic {
    @Override
    public void send() {
        System.out.println("AirLogistic send");
    }
}

// Here we abstracted the core object creation outside the service
class LogisticsFactory{
    public static Logistic getLogistic(String mode){
        if(mode.equals("RoadLogistic")){
            return new RoadLogistic();
        }
        else{
            return new AirLogistic();
        }
    }
}
class LogisticsService{
    public void send(String mode){
        Logistic logistic = LogisticsFactory.getLogistic(mode);
        logistic.send();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
