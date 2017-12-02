package mw.ankara.fur;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Context {

    @Value("#{settings['fur.environment']}")
    public String environment;

    @Value("#{settings['fur.domain']}")
    public String domain;

    @Value("#{settings['fur.img']}")
    public String img;
}
