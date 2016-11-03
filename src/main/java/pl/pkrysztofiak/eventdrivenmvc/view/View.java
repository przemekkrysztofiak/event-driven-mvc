package pl.pkrysztofiak.eventdrivenmvc.view;

import java.awt.geom.Point2D.Double;

import pl.pkrysztofiak.eventdrivenmvc.events.ViewEvents;

public class View extends AbstractView implements ViewEvents {

    public View() {
        initEvents();
    }

    @Override
    public void onShow(Double coordinates) {

    }

}
