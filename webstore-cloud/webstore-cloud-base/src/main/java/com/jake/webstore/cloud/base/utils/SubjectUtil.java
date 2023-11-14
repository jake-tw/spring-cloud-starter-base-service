package com.jake.webstore.cloud.base.utils;

import lombok.Builder;

public class SubjectUtil {
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

    @Builder
    public record Subject(String token, Long id) {
    }
}