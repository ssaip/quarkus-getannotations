package com.example;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;

@Priority(1)
@InheritedAnnotation
@ApplicationScoped
public class AnnotatedClass {
}
