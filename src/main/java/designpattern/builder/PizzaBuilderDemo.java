package designpattern.builder;

// https://sourcemaking.com/design_patterns/builder/java/2
// https://www.journaldev.com/1425/builder-design-pattern-in-java

/* A customer ordering a pizza. */
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println("" + pizza.toString());
    }
}