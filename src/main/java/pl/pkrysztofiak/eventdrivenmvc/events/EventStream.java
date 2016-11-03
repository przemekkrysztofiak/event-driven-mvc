package pl.pkrysztofiak.eventdrivenmvc.events;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EventStream<E> {

    private Map<EventPublishable, Consumer<E>> eventHandlers = new HashMap<>();

    void subscribe(EventPublishable eventPublishable, Consumer<E> eventHandler) {
        eventHandlers.put(eventPublishable, eventHandler);
    }

    public Publishable<E> forEach(EventPublishable... eventsPublishables) {
        return new Publisher(
                Arrays.asList(eventsPublishables).stream().map(
                        eventPublishable -> eventHandlers.get(eventPublishable)).collect(
                                Collectors.toList()));
    }

    public Publishable<E> forAll() {
        return new Publisher(eventHandlers.values());
    }

    private class Publisher implements Publishable<E> {

        private Collection<Consumer<E>> eventHandlers;

        private Publisher(Collection<Consumer<E>> eventHandlers) {
            this.eventHandlers = eventHandlers;
        }

        @Override
        public void publish(E event) {
            eventHandlers.forEach(eventHandler -> eventHandler.accept(event));
        }

    }
}
