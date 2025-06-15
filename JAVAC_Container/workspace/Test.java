
public class Test {
    private static int something = 0;
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(getNum());

        Library lib = new Library("lona", 0, 3);
        Library lib2 = new Library("lona", 0, 3);
        Library lib3 = new Library("lona", 0, 3);
        System.out.println(lib.getNumOpenLibrary());
        lib.closeLibrary();
        System.out.println(lib.getNumOpenLibrary());
        lib.openLibrary();
        System.out.println(lib.getNumOpenLibrary());

        lib3.openLibrary();

        lib2.closeLibrary();
        lib.closeLibrary();
        System.out.println(lib.getNumOpenLibrary());

        // Parent class
        // Child class
        // Child class extends Parent Class
        // Child is both an instance of itself and the parent clas
        // i.e. Cat extends Truck, Cat is both Cat and Truck but Truck is only Truck not Cat.

        // cat extends animal
        // gorilla extends animnal
        // dog extends animal

        for (all aninmals, make them poop) {
            if (cat)
                make it do cat poop

            Animals[] have a lit of Animals

        }
        
        Animal somethign = new Cat();
        Cat another = new Cat();

        Animal[] listofanimals =  new Animal[3];
        listofanimals[0] = somethign;
        listofanimals[1] = another;
    }

    public static int getNum() {
        return something;
    }
}