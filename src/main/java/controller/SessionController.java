package controller;

import controller.session.DownwardSession;
import controller.session.GrowthSession;
import controller.session.StaticSession;

import model.CurrencyHistory;


public class SessionController extends Reader {

    public void countSession() throws Exception {

        CurrencyHistory currencyHistory = printOptionsAndRead();

        GrowthSession growthSession = new GrowthSession();
        StaticSession staticSession = new StaticSession();
        DownwardSession downwardSession = new DownwardSession();

        growthSession.countSession(currencyHistory.getRates());
        staticSession.countSession(currencyHistory.getRates());
        downwardSession.countSession(currencyHistory.getRates());

        System.out.println("Liczba sesji wzrostowych: " + growthSession.getGrowthSessionCounter());
        System.out.println("Liczba sesji stałych: " + staticSession.getStaticSessionCounter());
        System.out.println("Liczba sesji spadkowych: " + downwardSession.getDownwardSessionCounter());
    }


}