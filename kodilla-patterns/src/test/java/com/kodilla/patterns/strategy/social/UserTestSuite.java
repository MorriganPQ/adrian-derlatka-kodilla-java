package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User facebookUser = new Millenials("[Facebook user]");
        User twitterUser = new YGeneration("[Twitter user]");
        User snapchatUser = new ZGeneration("[Snapchat user]");

        //When
        String facebookPost = facebookUser.sharePost();
        System.out.println(facebookUser.getUsername() + " " + facebookPost);
        String twitterPost = twitterUser.sharePost();
        System.out.println(twitterUser.getUsername() + " " + twitterPost);
        String snapchatPost = snapchatUser.sharePost();
        System.out.println(snapchatUser.getUsername() + " " + snapchatPost);

        //Then
        Assert.assertEquals("Sharing on Facebook", facebookPost);
        Assert.assertEquals("Sharing on Twitter", twitterPost);
        Assert.assertEquals("Sharing on Snapchat", snapchatPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User facebookUser = new Millenials("[Facebook user]");

        //When
        String facebookPost = facebookUser.sharePost();
        System.out.println(facebookUser.getUsername() + " " + facebookPost + " (before making a change)");
        facebookUser.setSocialPublisher(new TwitterPublisher());
        facebookPost = facebookUser.sharePost();
        System.out.println(facebookUser.getUsername() + " " + facebookPost + " (after making a change)");

        //Then
        Assert.assertEquals("Sharing on Twitter", facebookPost);
    }
}
