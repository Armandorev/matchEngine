package net.sinoriel;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MatchEngineApplication.class)
public class MatchEngineApplicationTests {

    @Autowired
    MatchEngine matchEngine;

    @Test
    public void matchEngineReturnMatchResult() {
        Assert.assertThat(matchEngine.getResult(),
                Matchers.isOneOf(
                        MatchEngine.MatchResult.LOCAL_WINS,
                        MatchEngine.MatchResult.DRAW,
                        MatchEngine.MatchResult.VISITOR_WINS));

    }

    @Test
    public void matchEngineReturnsGoals() throws Exception {
        Assert.assertThat(matchEngine.getLocalGoals(),Matchers.instanceOf(Integer.class));
        Assert.assertThat(matchEngine.getVisitorGoals(),Matchers.instanceOf(Integer.class));

    }

    @Test
    public void matchResultMatchsGoals() throws Exception {
        if (matchEngine.getLocalGoals()>matchEngine.getVisitorGoals()){
            Assert.assertThat(matchEngine.getResult(),Matchers.equalTo(MatchEngine.MatchResult.LOCAL_WINS));
        }else if(matchEngine.getLocalGoals()<matchEngine.getVisitorGoals()){
            Assert.assertThat(matchEngine.getResult(),Matchers.equalTo(MatchEngine.MatchResult.VISITOR_WINS));
        }
        else{
            Assert.assertThat(matchEngine.getResult(),Matchers.equalTo(MatchEngine.MatchResult.DRAW));
        }

    }

    @Test
    public void matchEngineReturnsMatchSummaryWithGoals() {
        Integer localGoals = matchEngine.getLocalGoals();
        Integer visitorGoals = matchEngine.getVisitorGoals();
        Assert.assertThat(matchEngine.getSummary(),Matchers.instanceOf(String.class));
        Assert.assertThat(matchEngine.getSummary(),Matchers.equalTo(localGoals+"-"+visitorGoals));
    }
}
