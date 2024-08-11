package com.lp.sealedClasses;

public abstract sealed class Shape permits Circle, Square, Triangle, NotAShape {

}
