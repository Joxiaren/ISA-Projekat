package com.rudari.isa.utility.datainit;

public class BaseDataInit<T>{
    BaseDataGenerator<T> generator;

    public BaseDataInit(BaseDataGenerator<T> generator) {
        this.generator = generator;
    }
}
