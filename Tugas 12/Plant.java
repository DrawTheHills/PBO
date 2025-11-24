public class Plant extends LivingBeing {

    public Plant(String name) {
        super(name);
    }

    @Override
    public void performActivity() {
        System.out.println(name + " performs photosynthesis and grows toward light.");
    }

    @Override
    public void reproduce() {
        System.out.println(name + " reproduces through seeds, spores, or vegetative propagation.");
    }

    public void photosynthesize() {
        System.out.println(name + " is producing energy through photosynthesis.");
    }
}
