public abstract class Animal {
    private String specie;
    
    
    public Animal() {

    }

    public abstract void eat();
    public abstract void mate(Animal mater);
    public void poop() {
        System.out.println("pooped");
    }

    public void setName(String in) {
        specie = in;
    }

}
