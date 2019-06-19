package model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyList
{
    @SerializedName("table")
    @Expose
    private String table;
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("effectivedate")
    @Expose
    private String effectivedate;
    @SerializedName("rates")
    @Expose
    private List<Table> tableRates = null;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(String effectivedate) {
        this.effectivedate = effectivedate;
    }

    public List<Table> getTableRates() {
        return tableRates;
    }

    public void setTableRates(List<Table> tableRates) {
        this.tableRates = tableRates;
    }
}
