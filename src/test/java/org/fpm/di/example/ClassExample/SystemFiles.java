package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SystemFiles
{
    private final SomeGameConfiguration smGconf;
    private final SomeProgramConfiguration smPconf;
    @Inject
    public SystemFiles(SomeGameConfiguration smGconf, SomeProgramConfiguration smPconf)
    {
        this.smGconf = smGconf;
        this.smPconf = smPconf;
    }
    public SomeGameConfiguration getSomeGameConfiguration()
    {
        return smGconf;
    }
    public SomeProgramConfiguration getSomeProgramConfiguration()
    {
        return smPconf;
    }
}