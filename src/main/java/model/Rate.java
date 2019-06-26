package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;

public class Rate implements Comparable< Rate >{

    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("effectiveDate")
    @Expose
    private String effectiveDate;
    @SerializedName("mid")
    @Expose
    private Double mid;

    public Rate(String no, String effectiveDate, Double mid)
    {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Double getMid() {
        DecimalFormat df = new DecimalFormat("#.##");
        String midString = df.format(mid);
        midString = midString.replace(",", ".");

        return Double.valueOf(midString);
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    @Override
    public int compareTo(Rate o) {
        return this.getMid().compareTo(o.getMid());
    }

}