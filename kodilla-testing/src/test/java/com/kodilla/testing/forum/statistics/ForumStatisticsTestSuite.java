package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.*;

import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {
    @Test
    public void testPostsEqualsZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for(int i = 0; i < 32; i++) users.add("user" + i);
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.commentsCount()).thenReturn(488);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0.0, forumStatistics.getAvgPostsPerUser(), 0.0);
        Assert.assertEquals(15.25, forumStatistics.getAvgCommentsPerUser(), 0.0);
        Assert.assertEquals(-1.0, forumStatistics.getAvgCommentsPerPost(), 0.0);
    }

    @Test
    public void testPostsEqualsOneThousandAndCommentsLessThanPosts() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for(int i = 0; i < 32; i++) users.add("user" + i);
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(488);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(31.25, forumStatistics.getAvgPostsPerUser(), 0.0);
        Assert.assertEquals(15.25, forumStatistics.getAvgCommentsPerUser(), 0.0);
        Assert.assertEquals(0.488, forumStatistics.getAvgCommentsPerPost(), 0.0);
    }

    @Test
    public void testCommentsEqualsZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for(int i = 0; i < 32; i++) users.add("user" + i);
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(244);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(7.625, forumStatistics.getAvgPostsPerUser(), 0.0);
        Assert.assertEquals(0.0, forumStatistics.getAvgCommentsPerUser(), 0.0);
        Assert.assertEquals(0.0, forumStatistics.getAvgCommentsPerPost(), 0.0);
    }

    @Test
    public void testUsersEqualsZero() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(45);
        when(statistics.commentsCount()).thenReturn(42);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(-1.0, forumStatistics.getAvgPostsPerUser(), 0.0);
        Assert.assertEquals(-1.0, forumStatistics.getAvgCommentsPerUser(), 0.0);
        Assert.assertEquals(0.933, forumStatistics.getAvgCommentsPerPost(), 0.001);
    }

    @Test
    public void testUsersEqualsOneHundredAndCommentsMoreThanPosts() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for(int i = 0; i < 100; i++) users.add("user" + i);
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(45);
        when(statistics.commentsCount()).thenReturn(48);
        //When
        forumStatistics.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0.45, forumStatistics.getAvgPostsPerUser(), 0.0);
        Assert.assertEquals(0.48, forumStatistics.getAvgCommentsPerUser(), 0.0);
        Assert.assertEquals(1.066, forumStatistics.getAvgCommentsPerPost(), 0.001);
    }
}
