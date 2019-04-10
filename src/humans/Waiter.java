package humans;

import humans.actions.Serve;
import street.Table;

public class Waiter extends Human implements Serve {

    private final String colour;//цвет костюма
    public Waiter(String name) {
        super(name);
        this.colour = "Зелёный";
    }
    public Waiter(String name, String colour){
        super(name);
        this.colour = colour;
    }

    //Создаёт локальный класс костюм и возвращает его toString и владельца
    public String suitUp(String colour){
        class Suit{
            private String colour;
            Suit(String colour) {
                this.colour = colour;
            }

            @Override
            public String toString() {
                return colour+" костюм";
            }

            public boolean equals(Suit suit) {
                return colour.equals(suit.colour);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        }
        Suit suit = new Suit(colour);
        return toString()+" одет в " + suit.toString();
    }

    @Override
    public String toString() {
        return "Официант " + getName();
    }

    public void serveTable(Table table){
        System.out.println(suitUp(colour) + " обслуживает столик с " + table.getCustomer().toString());
    }

    @Override
    public boolean equals(Human human) {
        return super.equals(human);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
