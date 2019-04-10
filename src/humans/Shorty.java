package humans;

import exceptions.MusicOffException;
import food.Food;
import humans.actions.Dance;
import humans.actions.Hunger;
import street.Street;
import street.Table;

public class Shorty extends Human implements Hunger {
    private Table table;

    public Shorty(String name) {
        super(name);
    }

    //Танцует, а если нет музыки, включает её
    public void danceOnStreet(Street street) {
        Dance dance = (music) -> {//new Dance(Music music) анонимный класс_
            if(!music.isPlaying()){
                throw new MusicOffException();
            }
            return "танцует под музыку " + music.toString();
        };
        try {
            System.out.println(toString() +" "+ dance.danceToMusic(street.getMusic()) +" на " + street.toString());
        } catch (MusicOffException e) {
            e.printStackTrace();
            System.out.println(toString() + " включает музыку");
            street.getMusic().setPlaying(true);
            danceOnStreet(street);
        }
    }

    @Override
    public String toString() {
        return "Коротышка " + getName();
    }

    @Override
    public void orderFood(Food[] foods, Waiter waiter) {
        System.out.print(toString() + " позвал " + waiter.toString() + " заказал еду: ");
        outFood(foods);
        waiter.serveTable(table);
        eat(foods);
    }

    //Вывод списка еды
    private void outFood(Food[] foods) {
        int i = 1;
        for (Food food: foods) {
            System.out.print(food.toString());
            if(i!=foods.length){
                System.out.print(", ");
                i++;
            }
        }
        System.out.println();
    }

    @Override
    public void goToTable(Street street) {
        for (Table table: street.getTables()) {
            if(!table.isEmpty()){
                table.setCustomers(this);
                this.table = table;
                System.out.println(toString() + " нашёл свободный столик, пошёл и сел за него");
                return;
            }
            System.out.println(toString() + " не нашёл свободный столик :(");
        }
    }

    @Override
    public void eat(Food[] foods) {
        System.out.print(toString()+ " ест ");
        outFood(foods);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean equals(Shorty shorty) {
        return !super.equals(shorty) &&table.equals(shorty.getTable());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
