package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DummyBinder implements Binder
{
    List<Class<?>> LIST = new ArrayList<>();
    HashMap<Class<?>, Object> Instance = new HashMap<>();
    HashMap<Class<?>, Object> Implementation = new HashMap<>();
    @Override
    public <T> void bind(Class<T> clazz)
    {
        LIST.add(clazz);
    }
    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation)
    {
        Implementation.put(clazz, implementation);
    }
    @Override
    public <T> void bind(Class<T> clazz, T instance)
    {
        Instance.put(clazz, instance);
    }
}
