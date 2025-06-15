public class Cat extends Animal implements Breathing {
    
    public Cat() {
        super.setName("cat");
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }

    @Override
    public void poop() {
        System.out.println("shatted");
    }

    public void mate(Cat cat) {

    }

    @Override
    public void breathethroughNose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'breathethroughNose'");
    }

    @Override
    public void breatheThroughButt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'breatheThroughButt'");
    }

    @Override
    public void breatheThroughMouth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'breatheThroughMouth'");
    }

    @Override
    public void mate(Animal mater) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mate'");
    }
}
