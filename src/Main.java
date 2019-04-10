import food.Food;
import food.FoodType;
import humans.Shorty;
import humans.Waiter;
import street.Building;
import street.BuildingType;
import street.Street;
import street.Table;

public class Main {
    public static void main(String[] args) {

        Building[] buildings = new Building[]{
                new Building("EAT more", BuildingType.RESTAURANT),
                new Building("Пиликан", BuildingType.BAR)
        };

        Shorty[] dancingShorties = new Shorty[]{
                new Shorty("Амелия"),
                new Shorty("Игнат")
        };

        Table[] tables = new Table[]{
                new Table(new Shorty("Кек")),
                new Table(new Shorty("Лол")),
                new Table(),
                new Table()
        };

        Food[] foods = new Food[]{
                new Food("Чай", FoodType.DRINK),
                new Food("Кофе", FoodType.DRINK),
                new Food("Газированная вода с сиропом", FoodType.DRINK),
                new Food("Мороженное", FoodType.MEAL),
                new Food("Чипсы", FoodType.SNACK),
        };

        //Street street = new Street(buildings, tables, "Улица Вязов", false);//Вызывает checked MusicOffException
        Street street = new Street(buildings, tables, "Улица Вязов", true);
        street.addBuilding(new Building("Бублик", BuildingType.CAFE));
        //street.addTable(null); //Вызывает unchecked NoTableException
        street.addTable(new Table());
        Shorty stupidOne = new Shorty("Незнайка");
        Waiter waiter = new Waiter("Валера", "Чёрный");


        street.info();
        System.out.println();

        street.tablesInfo();
        System.out.println();

        for (Shorty shorty: street.tablesCustomers()) {
            int i = (int)Math.round(Math.random()*2);
            int j= (int)Math.round(Math.random()+3);
            shorty.orderFood(new Food[]{foods[i], foods[j]}, waiter);
            System.out.println();
        }

        for (Shorty shorty: dancingShorties) {
            shorty.danceOnStreet(street);
        }

        System.out.println();
        stupidOne.goToTable(street);
        stupidOne.orderFood(new Food[]{
                new Food("Суп", FoodType.MEAL),
                new Food("Макароны с сыром", FoodType.MEAL),
                new Food("Голубцы", FoodType.MEAL),
                new Food("Голубцы", FoodType.MEAL),
                new Food("Кофе", FoodType.DRINK),
                new Food("Клубничное мороженное", FoodType.SNACK),

        }, waiter);
    }
}
