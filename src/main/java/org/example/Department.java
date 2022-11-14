package org.example;

import java.util.Objects;

public class Department {
    private final String code;
    private String name;

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{code=" + code + " name=" + name + "} ";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Department that = (Department) other;
        return code.equals(that.code) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
