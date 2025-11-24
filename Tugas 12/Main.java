public class MainApp {
    public static void main(String[] args) {

        Human student = new Human("Kevin");
        Human teacher = new Human("Maria");

        student.showInfo();
        student.performActivity();
        student.reproduce();
        student.speak();

        System.out.println();

        teacher.showInfo();
        teacher.performActivity();
        teacher.reproduce();
        teacher.speak();

        System.out.println("--------------------------------");

        Animal lion = new Animal("Leo");
        Animal eagle = new Animal("Aquila");

        lion.showInfo();
        lion.performActivity();
        lion.reproduce();
        lion.move();

        System.out.println();

        eagle.showInfo();
        eagle.performActivity();
        eagle.reproduce();
        eagle.move();

        System.out.println("--------------------------------");

        Plant cactus = new Plant("Cactus");
        Plant sunflower = new Plant("Sunflower");

        cactus.showInfo();
        cactus.performActivity();
        cactus.reproduce();
        cactus.photosynthesize();

        System.out.println();

        sunflower.showInfo();
        sunflower.performActivity();
        sunflower.reproduce();
        sunflower.photosynthesize();
    }
}
