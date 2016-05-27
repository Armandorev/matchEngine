package net.sinoriel;

import java.security.SecureRandom;

/**
 * Created by armandosanchezmedina on 24/05/2016.
 */
public class Half {

    private Integer localGoals;

    private Integer visitorGoals;

    public Half() {
        SecureRandom secureRandom = new SecureRandom();
        localGoals = secureRandom.nextInt(255);
        visitorGoals = secureRandom.nextInt(255);
    }

    public Integer getVisitorGoals() {
        return visitorGoals;
    }

    public Integer getLocalGoals() {
        return localGoals;
    }
}
