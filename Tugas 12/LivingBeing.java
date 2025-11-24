public abstract class LivingBeing {
    protected String name;

    public LivingBeing(String name) {
        this.name = name;
    }

    public abstract void performActivity();
    public abstract void reproduce();

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Living beings carry out life processes to survive.");
    }
}
