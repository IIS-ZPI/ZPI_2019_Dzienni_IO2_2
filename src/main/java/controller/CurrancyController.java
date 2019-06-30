package controller;

import com.google.gson.Gson;
import endpoint.NbpEndpoint;
import model.CurrencyHistory;
import model.CurrencyList;

public class CurrancyController {

    private String name;
    private String startDate;
    private String endDate;

    private NbpEndpoint nbpEndpoint = new NbpEndpoint();
    private Gson gson = new Gson();

    public CurrancyController(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CurrencyHistory getHistory() throws Exception {
        return gson.fromJson(nbpEndpoint.sendRequest(false, name, startDate, endDate), CurrencyHistory.class);
    }

    public CurrencyList getCurrencyList() throws Exception {
        CurrencyList[] enums = gson.fromJson(nbpEndpoint.sendRequest(true, name, startDate, endDate), CurrencyList[].class);
        return enums[0];
    }
}
