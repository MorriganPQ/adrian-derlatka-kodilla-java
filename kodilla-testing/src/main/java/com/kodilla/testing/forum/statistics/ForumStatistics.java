package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int allUsers;
    private int allPosts;
    private int allComments;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        allUsers = statistics.usersNames().size();
        allPosts = statistics.postsCount();
        allComments = statistics.commentsCount();
        if(allUsers != 0) {
            avgPostsPerUser = (double)allPosts / (double)allUsers;
            avgCommentsPerUser = (double)allComments / (double)allUsers;
        } else {
            avgPostsPerUser = -1.0;
            avgCommentsPerUser = -1.0;
        }
        if(allPosts != 0) avgCommentsPerPost = (double)allComments / (double)allPosts;
        else avgCommentsPerPost = -1.0;
    }

    public void showStatistics() {
        System.out.println("All users: " + allUsers);
        System.out.println("All posts: " + allPosts);
        System.out.println("All comments: " + allComments);
        System.out.println("Average posts per user: " + avgPostsPerUser);
        System.out.println("Average comments per user: " + avgCommentsPerUser);
        System.out.println("Average comments per post: " + avgCommentsPerPost);
    }

    public int getAllUsers() {
        return allUsers;
    }

    public int getAllPosts() {
        return allPosts;
    }

    public int getAllComments() {
        return allComments;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
