package org.vaadin.hene.dashboard.feed;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Henri Kerola / Vaadin
 */
public class ForumFeedProviderTest {

    private ForumFeedProvider forumFeedProvider;

    @Before
    public void setUp() throws Exception {
        forumFeedProvider = new ForumFeedProvider();
    }

    @Test
    public void trimTitle_ReInBeginningOfString_ReIsRemovedFromBeginningOfString() throws Exception {
        assertEquals("my title", forumFeedProvider.trimTitle("RE: my title"));
    }

    @Test
    public void trimTitle_StringContainsMultipleRes_ReIsRemovedOnlyFromBeginningOfString() throws Exception {
        assertEquals("my RE: titleRE: ", forumFeedProvider.trimTitle("RE: my RE: titleRE: "));
    }
}