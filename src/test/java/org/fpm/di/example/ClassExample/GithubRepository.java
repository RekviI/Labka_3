package org.fpm.di.example.ClassExample;

import javax.inject.Inject;

public class GithubRepository
{
    private final DiskD diskD;
    private final DiskC diskC;
    @Inject
    public GithubRepository(DiskD reposDiskD, DiskC reposDiskC)
    {
        this.diskD = reposDiskD;
        this.diskC = reposDiskC;
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
