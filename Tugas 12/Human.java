public class Human extends LivingBeing {

    public Human(String name) {
        super(name);
    }

    @Override
    public void performActivity() {
        System.out.println(name + " performs activities such as working, studying, and communicating.");
    }

    @Override
    public void reproduce() {
        System.out.println(name + " reproduces through giving birth (viviparous).");
    }

    public void speak() {
        System.out.println(name + " can communicate using language.");
    }
}
