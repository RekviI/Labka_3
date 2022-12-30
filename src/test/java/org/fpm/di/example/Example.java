package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.ClassExample.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    /* Мої тести */

    @Test
    public void InjectSingleton()
    {
        final MyComputer Computer = container.getComponent(MyComputer.class);
        final ModPack BetaModPack = container.getComponent(ModPack.class);
        final GithubRepository MainRepos = container.getComponent(GithubRepository.class);
        final GithubRepository TestRepos = container.getComponent(GithubRepository.class);

        assertSame(Computer, container.getComponent(MyComputer.class));
        assertSame(container.getComponent(DiskD.class), container.getComponent(DiskD.class));
        assertSame(BetaModPack, container.getComponent(ModPack.class));
        assertSame(TestRepos.getDiskC(), container.getComponent(DiskC.class));
        assertSame(MainRepos.getDiskD(), TestRepos.getDiskD());
    }

    @Test
    public void InjectPrototype()
    {
        final MyExample GoodExample = container.getComponent(MyExample.class);
        final SomeProgramConfiguration VSconf = container.getComponent(SomeProgramConfiguration.class);
        final SomeGameConfiguration CSGOconf = container.getComponent(SomeGameConfiguration.class);

        assertNotSame(container.getComponent(MyExample.class), container.getComponent(MyExample.class));
        assertNotSame(container.getComponent(MyExample.class), GoodExample);
        assertNotSame(container.getComponent(SomeGameConfiguration.class), container.getComponent(SomeGameConfiguration.class));
        assertNotSame(container.getComponent(SomeProgramConfiguration.class), container.getComponent(SomeProgramConfiguration.class));
        assertNotSame(container.getComponent(SomeProgramConfiguration.class), VSconf);
        assertNotSame(container.getComponent(SomeGameConfiguration.class), CSGOconf);

    }
    @Test
    public void ComplicatedTesting()
    {
        final MyComputer Computer = container.getComponent(MyComputer.class);
        final SystemFiles System32 = container.getComponent(SystemFiles.class);
        final DiskD LocalDiskD = container.getComponent(DiskD.class);
        final DiskC LocalDiskC = container.getComponent(DiskC.class);
        final Cyberpunk2077 Patch = container.getComponent(Cyberpunk2077.class);

        assertSame(Computer.getDiskD(), container.getComponent(DiskD.class));
        assertSame(Computer.getDiskC(), container.getComponent(DiskC.class));
        assertNotSame(System32.getSomeProgramConfiguration(), container.getComponent(SomeProgramConfiguration.class));
        assertNotSame(System32.getSomeGameConfiguration(), container.getComponent(SomeGameConfiguration.class));
        assertSame(container.getComponent(Study.class), LocalDiskD.getStudy());
        assertSame(container.getComponent(Games.class), LocalDiskD.getGames());
        assertSame(container.getComponent(Cyberpunk2077.class), LocalDiskD.getGames().getCyberpunk2077());
        assertNotSame(LocalDiskC.getSystemFiles().getSomeGameConfiguration(), container.getComponent(SomeGameConfiguration.class));
        assertNotSame(LocalDiskC.getSystemFiles().getSomeProgramConfiguration(), container.getComponent(SomeProgramConfiguration.class));
        assertSame(Patch.getModPack(), container.getComponent(ModPack.class));
    }
    @Test
    public void BuildInjectDepend()
    {
        final Study NewStudy = container.getComponent(Study.class);
        final Java NewJava = container.getComponent(Java.class);
        final Labka3 NewLabka3 = container.getComponent(Labka3.class);
        final MyExample NewExample = container.getComponent(MyExample.class);
        final GithubRepository Rep = container.getComponent(GithubRepository.class);
        final MyComputer Comp = container.getComponent(MyComputer.class);
        final SomeProgramConfiguration Pconf = container.getComponent(SomeProgramConfiguration.class);


        assertNotSame(NewJava, container.getComponent(Java.class));
        assertNotSame(NewJava, container.getComponent(Labka3.class));
        assertNotSame(NewJava, container.getComponent(MyExample.class));
        assertNotSame(NewLabka3, NewJava);
        assertNotSame(NewLabka3, NewExample);
        assertNotSame(NewStudy.getJava(), container.getComponent(Java.class));
        assertNotSame(Pconf, Comp.getDiskC().getSystemFiles().getSomeProgramConfiguration());
        assertNotSame(Pconf, Rep.getDiskC().getSystemFiles().getSomeProgramConfiguration());
    }
}
