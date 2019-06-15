package com.example.veradebora.dds.Object;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class DetailsOfBillHistoObject {
    private String flavor;
    private String price;
    private String Total;

    public DetailsOfBillHistoObject(String flavor, String price, String total) {

        this.flavor = flavor;
        this.price = price;
        Total = total;
    }

    public String getFlavor() {
        switch (flavor){
            case "1_1_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_1_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_1_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "1_2_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_2_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_2_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "1_4_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_4_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_4_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_1_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_1_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_1_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_2_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_2_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_2_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_4_20":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_4_40":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_4_80":
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t\t =\t  " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

        }
        return null;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }


}
