package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.ClassExample.*;

public class MyConfiguration implements Configuration
{
    @Override
    public void configure(Binder binder)
    {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        /*Мої бінди*/
        binder.bind(MyComputer.class);
        binder.bind(GithubRepository.class);
        binder.bind(ModPack.class, new ModPack());
        binder.bind(Java.class, Labka3.class);
        binder.bind(Labka3.class, MyExample.class);
    }
}
