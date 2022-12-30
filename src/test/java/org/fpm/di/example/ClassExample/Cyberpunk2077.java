package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Cyberpunk2077
{
    private final ModPack modpack;
    @Inject
    public Cyberpunk2077(ModPack modpack)
    {
        this.modpack = modpack;
    }
    public ModPack getModPack()
    {
        return modpack;
    }
}
