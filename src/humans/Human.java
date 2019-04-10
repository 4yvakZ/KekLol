package humans;

public abstract class Human {
    private final String name;

    protected Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Human human) {
        return name.equals(human.getName());
    }
}
