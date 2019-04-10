package humans.actions;

import food.Food;
import humans.Waiter;
import street.Street;

public interface Hunger {
    void orderFood(Food[] foods, Waiter waiter);
    void goToTable(Street street);
    void eat(Food[] foods);
}
