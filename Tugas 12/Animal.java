public class Animal extends LivingBeing {

    public Animal(String name) {
        super(name);
    }

    @Override
    public void performActivity() {
        System.out.println(name + " performs activities such as hunting, searching for food, or migrating.");
    }

    @Override
    public void reproduce() {
        System.out.println(name + " may reproduce by laying eggs or giving birth depending on the species.");
    }

    public void move() {
        System.out.println(name + " is moving around.");
    }
}
