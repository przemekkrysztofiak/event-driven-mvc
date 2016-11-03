package pl.pkrysztofiak.eventdrivenmvc.events;

public interface Publishable<E> {

    void publish(E event);
}
