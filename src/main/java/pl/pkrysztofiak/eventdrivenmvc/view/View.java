package pl.pkrysztofiak.eventdrivenmvc.view;

import pl.pkrysztofiak.eventdrivenmvc.events.EventStream;
import pl.pkrysztofiak.eventdrivenmvc.events.ViewEvents;

public class View extends AbstractView implements ViewEvents {

    public static void main(String[] args) {

    }

    void dosth() {
        EventStream<Void> show = new EventStream<>();
        show.forEach(this).publish(null);
    }
}
