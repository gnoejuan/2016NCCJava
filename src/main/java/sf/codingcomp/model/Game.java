package sf.codingcomp.model;

import com.google.gson.annotations.SerializedName;

public class Game extends Entertainment {

    @SerializedName( "StockLNX" )
    private String stockLnx;
    @SerializedName( "StockMAC" )
    private String stockMac;
    @SerializedName( "StockPC" )
    private String stockPc;
    @SerializedName( "StockPSP" )
    private String stockPsp;
    @SerializedName( "StockPS2" )
    private String stockPs2;
    @SerializedName( "StockPS3" )
    private String stockPs3;
    @SerializedName( "StockPS4" )
    private String stockPs4;
    @SerializedName( "StockX" )
    private String stockX;
    @SerializedName( "StockX360" )
    private String stockX360;
    @SerializedName( "StockX1" )
    private String stockX1;
    @SerializedName( "StockWii" )
    private String stockWii;
    @SerializedName( "StockWiiU" )
    private String stockWiiU;
    @SerializedName( "Platform" )
    private String platform;

    public String getStockLnx() {
        return stockLnx;
    }

    public void setStockLnx( String stockLnx ) {
        this.stockLnx = stockLnx;
    }

    public String getStockMac() {
        return stockMac;
    }

    public void setStockMac( String stockMac ) {
        this.stockMac = stockMac;
    }

    public String getStockPc() {
        return stockPc;
    }

    public void setStockPc( String stockPc ) {
        this.stockPc = stockPc;
    }

    public String getStockPsp() {
        return stockPsp;
    }

    public void setStockPsp( String stockPsp ) {
        this.stockPsp = stockPsp;
    }

    public String getStockPs2() {
        return stockPs2;
    }

    public void setStockPs2( String stockPs2 ) {
        this.stockPs2 = stockPs2;
    }

    public String getStockPs3() {
        return stockPs3;
    }

    public void setStockPs3( String stockPs3 ) {
        this.stockPs3 = stockPs3;
    }

    public String getStockPs4() {
        return stockPs4;
    }

    public void setStockPs4( String stockPs4 ) {
        this.stockPs4 = stockPs4;
    }

    public String getStockX() {
        return stockX;
    }

    public void setStockX( String stockX ) {
        this.stockX = stockX;
    }

    public String getStockX360() {
        return stockX360;
    }

    public void setStockX360( String stockX360 ) {
        this.stockX360 = stockX360;
    }

    public String getStockX1() {
        return stockX1;
    }

    public void setStockX1( String stockX1 ) {
        this.stockX1 = stockX1;
    }

    public String getStockWii() {
        return stockWii;
    }

    public void setStockWii( String stockWii ) {
        this.stockWii = stockWii;
    }

    public String getStockWiiU() {
        return stockWiiU;
    }

    public void setStockWiiU( String stockWiiU ) {
        this.stockWiiU = stockWiiU;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform( String platform ) {
        this.platform = platform;
    }

}
