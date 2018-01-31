package designpattern.observer;

class Lighting implements AlarmListener {
    public void alarm() {
        System.out.println("lights up");
    }
}