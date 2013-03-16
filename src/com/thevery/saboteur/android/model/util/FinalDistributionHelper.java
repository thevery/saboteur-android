package com.thevery.saboteur.android.model.util;

public class FinalDistributionHelper {
    private final int miners;
    private final int saboteurs;

    public FinalDistributionHelper(int miners, int saboteurs) {
        this.miners = miners;
        this.saboteurs = saboteurs;
    }

    //todo: miners distribution

    public int getGoldPerSaboteur() {
        if (saboteurs == 0) return 0;
        if (saboteurs == 1) return 4;
        if (saboteurs <= 3) return 3;
        return 2;
    }
}
