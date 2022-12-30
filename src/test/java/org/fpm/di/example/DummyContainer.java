package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DummyContainer implements Container
{
    private final DummyBinder binder;
    public DummyContainer(DummyBinder bind)
    {
        this.binder = bind;
    }
    @Override
    public <T> T getComponent(Class<T> clazz)
    {
        if (binder.Instance.containsKey(clazz))
        {
            return (T) binder.Instance.get(clazz);
        }
        if (binder.Implementation.containsKey(clazz))
        {
            return getComponent((Class <T>) binder.Implementation.get(clazz));
        }
        try
        {
            /* Головна частина програми, в якій за циклом проходятья конструктори класу по Inject*/
            T var = null;
            for (Constructor<?> c: clazz.getConstructors())
            {
                if (c.isAnnotationPresent(Inject.class))
                {
                    Object[] parameters = new Object[c.getParameterCount()];
                    for (int i = 0; i < c.getParameterCount(); i++)
                    {
                        parameters[i] = getComponent(c.getParameters()[i].getType());
                    }
                    /* Створює інстанс переданого класу на вході конструктора */
                    var = (T) c.newInstance(parameters);
                }
            }
            if (var == null)
            {
                var = clazz.newInstance();
            }
            if (clazz.isAnnotationPresent(Singleton.class))
            {
                binder.bind(clazz, var);
            }
            return var;
        } catch(IllegalAccessException | InstantiationException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }

    /*(Початковий контейнер)
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (clazz.equals(A.class)) {
            return (T) new A();
        }
        if (clazz.equals(B.class)) {
            return (T) new B();
        }
        return null;
    }*/
}
