package com.personalproject.Course.Catalogue.comparators;

import com.personalproject.Course.Catalogue.models.CoursePost;

import java.time.LocalDate;
import java.util.Comparator;

public class CoursePostsComparator implements Comparator<CoursePost> {


    @Override
    public int compare(CoursePost cp1, CoursePost cp2) {
        long cp1UpvoteDownVoteDifference = cp1.getUpVotes() - cp1.getDownVotes();
        long cp2UpvoteDownVoteDifference = cp2.getUpVotes() - cp2.getDownVotes();
        if(cp1UpvoteDownVoteDifference != cp2UpvoteDownVoteDifference){
            return (int)(cp2UpvoteDownVoteDifference - cp1UpvoteDownVoteDifference);
        }
        else if(cp1.getUpVotes() != cp2.getUpVotes()){
            return(int)(cp2.getUpVotes() - cp1.getUpVotes());
        }
        else{   //sort by date
            LocalDate ld1 = cp1.getTimestamp();
            LocalDate ld2 = cp2.getTimestamp();
            System.out.println("Date compare of "+ld1+" and "+ld2+" : "+ld1.compareTo(ld2));

            return ld2.compareTo(ld1);              //show the latest course on top
        }
    }
}
