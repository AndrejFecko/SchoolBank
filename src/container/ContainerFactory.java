package container;

public class ContainerFactory {

    public Container newContainer() {
        return new Container(false);
    }

    public Container newContainerWithLogging() {
        return new Container(true);
    }
}
