package street;


public class Building {
    private final String name;
    private final BuildingType type;

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public BuildingType getType() {
        return type;
    }

    @Override
    public String toString() {
        String out;
        switch (type){
            case BAR:
                out = "Бар ";
                break;
            case CAFE:
                out = "Кафе ";
                break;
            case RESTAURANT:
                out = "Ресторан ";
                break;
                default:
                    out = "Здание с вывеской ";
                    break;
        }
        return out + name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Building building) {
        return name.equals(building.getName())&&type.equals(building.type);
    }
}
