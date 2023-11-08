package com.jake.webstore.cloud.base;

import lombok.Data;

public class SubjectUtils {
    private final static ThreadLocal<Subject> subjectLocal = new ThreadLocal<>();

    public static void set(Subject subject) {
        subjectLocal.set(subject);
    }

    public static Subject get() {
        return subjectLocal.get();
    }

    public static void delete() {
        subjectLocal.remove();
    }

    @Data
    public static class Subject {
        private int id;
    }
}