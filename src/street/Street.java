package street;

import exceptions.NoTableException;
import humans.Shorty;

public class Street {
    private Building[] buildings;
    private Table[] tables;
    private final String name;
    private final Music music;

    public Music getMusic() {
        return music;
    }

    public Table[] getTables() {
        return tables;
    }

    public void setTables(Table[] tables) {
        this.tables = tables;
    }

    public class Music{
        private String song;
        private boolean isPlaying;

        Music(boolean isPlaying){
            this.isPlaying = isPlaying;
            song = "Terrible Things - Brick + Mortar";
        }

        Music(String song, boolean isPlaying) {
            this.song = song;
            this.isPlaying = isPlaying;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        @Override
        public String toString() {
            return song;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Music music) {
            return song.equals(music.getSong())&&(isPlaying==music.isPlaying());
        }
    }
    public Street(Building[] buildings, Table[] tables, String name, boolean isMusicPlaying) {
        this.buildings = buildings;
        this.tables = tables;
        this.name = name;
        this.music = new Music(isMusicPlaying);
    }
    public Street(Building[] buildings, Table[] tables, String name, String music, boolean isMusicPlaying) {
        this.buildings = buildings;
        this.tables = tables;
        this.name = name;
        this.music = new Music(music, isMusicPlaying);
    }

    @Override
    public String toString() {
        return name;
    }

    public void info(){
        System.out.print("На "+ toString() + " находятся " + tables.length + " стола и " +buildings.length +" здания: ");
        int i = 1;
        for (Building building: buildings) {
            System.out.print(building.toString());
            if(i != buildings.length){
                System.out.print(", ");
                i++;
            }
        }
        System.out.println();
    }

    public void addBuilding(Building building){
        Building[] buildings1 = new Building[buildings.length + 1];
        System.arraycopy(buildings, 0, buildings1, 0, buildings.length);
        buildings1[buildings.length] = building;
        buildings = buildings1;
    }

    public void addTable(Table table){
        if(table == null){
            Table[] tables1 = new Table[tables.length + 1];
            System.arraycopy(tables, 0, tables1, 0, tables.length);
            tables1[tables.length] = table;
            tables = tables1;
            throw new NoTableException(new NullPointerException());
        }

    }

    public void tablesInfo(){
        int emptyTables = 0;
        for (Table table: tables) {
            if(!table.isEmpty()){
                System.out.println(table.getCustomer().toString() + " сидит за столом");
            }else {
                emptyTables++;
            }
        }
        System.out.println("Столов свободно " + emptyTables);
    }

    //Возвращает список посетителей за столами
    public Shorty[] tablesCustomers(){
        int customersNumber = 0;
        for (Table table: tables) {
            if(!table.isEmpty()){
                customersNumber++;
            }
        }
        Shorty[] shorties = new Shorty[customersNumber];
        int i = 0;
        for (Table table: tables) {
            if(!table.isEmpty()){
                shorties[i] = table.getCustomer();
                i++;
            }
        }
        return shorties;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Street street) {
        if(buildings.length== street.getBuildings().length) {
            for (int i = 0; i < buildings.length; i++) {
                if (!buildings[i].equals(street.getBuildings()[i])) {
                    return false;
                }
            }
        }else{
            return false;
        }
        if(tables.length==street.getTables().length){
            for (int i = 0; i < tables.length; i++) {
                if (!tables[i].equals(street.getTables()[i])) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return music.equals(street.getMusic())&&name.equals(street.getName());
    }
}
