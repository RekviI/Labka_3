package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Games
{
    private final Cyberpunk2077 cyberpunk2077;
    @Inject
    public Games(Cyberpunk2077 cyberpunk2077)
    {
        this.cyberpunk2077 = cyberpunk2077;
    }
    public Cyberpunk2077 getCyberpunk2077()
    {
        return cyberpunk2077;
    }
}
