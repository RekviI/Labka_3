package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DiskC
{
    private final SystemFiles systemfiles;
    @Inject
    public DiskC(SystemFiles systemfiles)
    {
        this.systemfiles = systemfiles;
    }
    public SystemFiles getSystemFiles()
    {
        return systemfiles;
    }
}