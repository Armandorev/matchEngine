package net.sinoriel;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by armandosanchezmedina on 24/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MatchEngineApplication.class)
public class MatchTest {

    @Autowired
    MatchEngine matchengine;

    @Test
    public void MatchShouldIncludeTwoHalfs(){
        Match match = matchengine.getMatch();
        Assert.assertThat(match.getFirstHalf(), Matchers.instanceOf(Half.class));
        Assert.assertThat(match.getSecondHalf(), Matchers.instanceOf(Half.class));
    }

    @Test
    public void FirstAndSecondHalfIncludesGoals(){
        Match match = matchengine.getMatch();
        Assert.assertThat(match.getFirstHalf().getLocalGoals(),Matchers.instanceOf(Integer.class));
        Assert.assertThat(match.getFirstHalf().getVisitorGoals(),Matchers.instanceOf(Integer.class));
        Assert.assertThat(match.getFirstHalf().getLocalGoals(),Matchers.instanceOf(Integer.class));
        Assert.assertThat(match.getFirstHalf().getVisitorGoals(),Matchers.instanceOf(Integer.class));
    }

}
