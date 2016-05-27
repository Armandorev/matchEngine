package net.sinoriel;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * Created by armandosanchezmedina on 20/05/2016.
 */
@Component
public class MatchEngine {
    
    private MatchResult result;
    private Integer localGoals;
    private Integer visitorGoals;
    private String summary;
    private Match match;



    public enum MatchResult {
        LOCAL_WINS,
        DRAW,
        VISITOR_WINS;

        public static MatchResult randomResult() {
            MatchResult[] results = MatchResult.values();
            SecureRandom generator = new SecureRandom();
            return results[generator.nextInt(results.length)];
        }
    }

    public MatchEngine() {
        SecureRandom secureRandom = new SecureRandom();
        localGoals = secureRandom.nextInt(255);
        visitorGoals = secureRandom.nextInt(255);
        if (localGoals > visitorGoals){
            result = MatchResult.LOCAL_WINS;
        } else if(visitorGoals>localGoals){
            result = MatchResult.VISITOR_WINS;
        } else {
            result = MatchResult.DRAW;
        }
        summary = localGoals+"-"+visitorGoals;

        match = new Match();

    }

    public Integer getLocalGoals() {
        return localGoals;
    }
    public Integer getVisitorGoals() {
        return visitorGoals;
    }

    public String getSummary() {
        return summary;
    }

    public MatchResult getResult() {
        return result;
    }

    public Match getMatch() {
        return match;
    }
}
