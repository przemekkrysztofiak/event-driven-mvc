package pl.pkrysztofiak.eventdrivenmvc.events;

import java.awt.geom.Point2D;

public interface ViewEvents extends EventPublishable {

    EventStream<Point2D.Double> show = new EventStream<>();

    default void initEvents() {
        show.subscribe(this, coordinates -> onShow(coordinates));
    }

    void onShow(Point2D.Double coordinates);
}
