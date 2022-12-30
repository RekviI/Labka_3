package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyComputer
{
    private final DiskD diskD;
    private final DiskC diskC;
    @Inject
    public MyComputer(DiskD diskD, DiskC diskC)
    {
        this.diskD = diskD;
        this.diskC = diskC;
    }
    public DiskD getDiskD()
    {
        return diskD;
    }
    public DiskC getDiskC()
    {
        return diskC;
    }
}
