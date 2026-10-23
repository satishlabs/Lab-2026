package com.link.coll.map;


class Employee2 {
    private final int id;
    private final String name;

    Employee2(int id, String name) {
        this.id = id;
        this.name = name;
    }

   /* @Override
    public int hashCode() {
        return 1;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee2)) return false;

        Employee2 other = (Employee2) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

