package com.example.veradebora.dds.Object;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class DetailsOfVmObject {

    private String flavor;
    private String  IpAddress;

    public DetailsOfVmObject(String flavor, String ipAddress) {
        this.flavor = flavor;
        this.IpAddress = ipAddress;
    }

    public String getFlavor() {
        switch (flavor){
            case "1_1_20":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_1_40":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_1_80":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "1_2_20":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_2_40":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_2_80":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "1_4_20":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "1_4_40":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "1_4_80":
                return "\t\t\t\t\t\t\t\t\t"+ "1 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_1_20":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_1_40":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_1_80":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "1 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_2_20":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_2_40":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_2_80":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "2 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

            case "2_4_20":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "20 GB Disk";

            case "2_4_40":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "40 GB Disk";

            case "2_4_80":
                return "\t\t\t\t\t\t\t\t\t"+ "2 VCPUs \n" +
                        "Vm Size \t=\t\t   " + "4 GB RAM \n" +
                        "\t\t\t\t\t\t\t\t\t" + "80 GB Disk";

        }
        return null;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

}
