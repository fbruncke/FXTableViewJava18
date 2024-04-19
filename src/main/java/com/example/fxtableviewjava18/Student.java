package com.example.fxtableviewjava18;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    //region getters setter
    private StringProperty name = new SimpleStringProperty(this,"name");
    private IntegerProperty age = new SimpleIntegerProperty(this, "age");

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
    //endregion

    public Student(String name, Integer age) {
        this.name.set(name);
        this.age.set(age);
    }


}
