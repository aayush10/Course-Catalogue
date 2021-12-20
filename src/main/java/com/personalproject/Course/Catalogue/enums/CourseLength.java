package com.personalproject.Course.Catalogue.enums;

public enum CourseLength {
    ONE_TWO_MONTHS("1-2 months")
    ,TWO_FOUR_MONTHS("2-4 months")
    ,FOUR_EIGHT_MONTHS("4-8 months")
    ,EIGHT_TWELVE_MONTHS("8-12 months")
    ,ONE_TWO_YEARS("1-2 years")
    ,TWO_FOUR_YEARS("2-4 years");
    private String value;
    CourseLength(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public String toString(){
        return getValue();
    }
}
