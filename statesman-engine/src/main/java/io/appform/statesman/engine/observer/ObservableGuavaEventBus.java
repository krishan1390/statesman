package io.appform.statesman.engine.observer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class ObservableGuavaEventBus implements ObservableEventBus {
    private final EventBus syncEventBus;
    private final ObservableEventBusSubscriber subscriber;

    @Inject
    public ObservableGuavaEventBus(@Named("workflowPersister") final ObservableEventBusSubscriber subscriber) {
        this.subscriber = subscriber;
        this.syncEventBus = new EventBus("events");
    }

    @Override
    public void publish(ObservableEvent event) {
        syncEventBus.post(event);
    }

    @Subscribe
    public void handleEvent(ObservableEvent event) {
        subscriber.handle(event);
    }
}