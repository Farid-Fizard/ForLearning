package com.example.demo.domain;

import java.util.Arrays;

public enum UserStatus {
    PENDING(1),
    ACTIVE(2),
    LOCKED(3),
    DELETED(4);
    private int id;

    UserStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static UserStatus from(int id){
       return Arrays.stream(values()).filter(userStatus -> userStatus.getId()==id)
                .findFirst()
                .orElseThrow( ()-> new IllegalArgumentException("Unknown user status for id"+id));
    }
}
