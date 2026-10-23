package com.link.coll.map;


class Employee1 {
    private final int id;
    private final String name;

    Employee1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee1)) return false;

        Employee1 other = (Employee1) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

