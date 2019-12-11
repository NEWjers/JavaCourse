package com.company;

import com.company.Model.Enrollee;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods{

    public List<Enrollee> filterSmallerThan(List<Enrollee> coll, int filterMark){
         return coll.stream().filter(x -> x.averageZNO()>=filterMark).collect(Collectors.toList());
    }

public void printNames(List<Enrollee> coll){
    coll.stream().forEach(x -> System.out.println(x.getName()));
}

}
