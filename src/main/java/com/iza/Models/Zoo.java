package com.iza.Models;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by anelson on 3/17/2016.
 */
public class Zoo {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Zoo rhs = (Zoo) obj;

        return new EqualsBuilder()
                .appendSuper(super.equals(rhs))
                .append(name, rhs.name)
                .isEquals();
    }
}
