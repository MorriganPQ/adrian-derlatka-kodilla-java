package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "Adoxonto", 'M', LocalDate.of(2000, 12, 12), 11));
        theForumUserList.add(new ForumUser(2, "Clawerpuma", 'F', LocalDate.of(1995, 8, 25), 0));
        theForumUserList.add(new ForumUser(3, "Eatsyouvers", 'M', LocalDate.of(1990, 7, 1), 0));
        theForumUserList.add(new ForumUser(4, "Furlard", 'M', LocalDate.of(1987, 12, 13), 1));
        theForumUserList.add(new ForumUser(5, "Invisino", 'F', LocalDate.of(2006, 10, 19), 45));
        theForumUserList.add(new ForumUser(6, "Linkinform", 'M', LocalDate.of(2002, 2, 22), 0));
        theForumUserList.add(new ForumUser(7, "MissFinal", 'F', LocalDate.of(1999, 2, 5), 1));
        theForumUserList.add(new ForumUser(8, "Psychecto", 'M', LocalDate.of(2001, 6, 30), 95));
        theForumUserList.add(new ForumUser(9, "Reptilectis", 'M', LocalDate.of(1998, 11, 11), 0));
        theForumUserList.add(new ForumUser(10, "TinnysBurnt", 'M', LocalDate.of(1997, 5, 20), 23));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
