package io.appform.statesman.server;

import io.appform.dropwizard.sharding.config.ShardedHibernateFactory;
import io.appform.statesman.publisher.impl.EventPublisherConfig;
import io.appform.statesman.server.callbacktransformation.CallbackTransformationTemplates;
import io.dropwizard.Configuration;
import io.dropwizard.riemann.RiemannConfig;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class AppConfig extends Configuration {

    @NotNull
    @Valid
    private ShardedHibernateFactory shards;

    @NotNull
    @Valid
    private RiemannConfig riemann;

    @NotNull
    @Valid
    private SwaggerBundleConfiguration swagger = new SwaggerBundleConfiguration();


    @NotNull
    @Valid
    private EventPublisherConfig eventPublisherConfig;

    @NotNull
    @Valid
    private CallbackTransformationTemplates callbackTransformationTemplates;

}
