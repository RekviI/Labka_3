package org.fpm.di.example.ClassExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DiskD
{
    private final Games games;
    private final Study study;
    @Inject
    public DiskD(Games games, Study study)
    {
        this.games = games;
        this.study = study;
    }
    public Games getGames()
    {
        return games;
    }
    public Study getStudy()
    {
        return study;
    }
}
