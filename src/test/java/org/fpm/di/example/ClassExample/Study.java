package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Study
{
    private final Java java;
    @Inject
    public Study(Java java)
    {
        this.java = java;
    }
    public Java getJava()
    {
        return java;
    }
}
