package com.lucida.point.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);

        Integer max = Collections.max(useCases);
        System.out.println(max);
        System.out.println(3|9);
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {

            for (Method m : cl.getDeclaredMethods()) {
                if (m.isAnnotationPresent(UseCase.class)) {
                    UseCase uc = m.getAnnotation(UseCase.class);
                    if (uc != null) {
                        System.out.println("Found Use Case:" + uc.id() + " "
                                + uc.description());
                        useCases.remove(new Integer(uc.id()));
                    }
                }
            }
            for (int i : useCases) {
                System.out.println("Warning: Missing use case-" + i);
            }
        }

}