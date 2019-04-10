package food;

public class Food {
    private final String name;
    private final FoodType foodType;

    public Food(String name, FoodType foodType) {
        this.name = name;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    @Override
    public String toString() {
        String out;
        switch (foodType){
            case MEAL:
                out = "блюдо ";
                break;
            case DRINK:
                out = "напиток ";
                break;
            case SNACK:
                out = "закуску ";
                break;
                default:
                    out = "Что-то съедобное под названием ";
                    break;
        }
        return out + name;
    }

    public boolean equals(Food food) {
        return name.equals(food.getName())&&foodType.equals(food.getFoodType());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
