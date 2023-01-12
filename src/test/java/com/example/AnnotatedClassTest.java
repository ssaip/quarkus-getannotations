package com.example;

import io.quarkus.arc.ClientProxy;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class AnnotatedClassTest {

    @Inject
    AnnotatedClass annotatedClass;

    @Test
    void testGetAnnotations() {
        int expectedAnnotationsPresent = 3;
        Assertions.assertEquals(expectedAnnotationsPresent, AnnotatedClass.class.getAnnotations().length);

        AnnotatedClass instance = new AnnotatedClass();
        Assertions.assertEquals(expectedAnnotationsPresent, instance.getClass().getAnnotations().length);

        var unwrapped = ClientProxy.unwrap(annotatedClass);
        Assertions.assertEquals(expectedAnnotationsPresent, unwrapped.getClass().getAnnotations().length);

        Assertions.assertEquals(expectedAnnotationsPresent, annotatedClass.getClass().getAnnotations().length);
    }
}
