package edu.gcccd.csis;

public class Company {

    private String compName;
    private int compWorkers;





    public Company(String companyName, int companyWorkers) {
        this.compName = companyName;
        this.compWorkers = companyWorkers;

    }
    public  Company () {
        compName = "Google";
        compWorkers = 10;
        }



    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getCompWorkers() {
        return compWorkers;
    }

    public void setCompWorkers(int compWorkers) {
        this.compWorkers = compWorkers;
    }







    public boolean equals(Company z) {
        if (this == z) {
            return true;
        }

        if (z == null) {
            return false;
        }
        if (z instanceof Company) {
            Company ctest = (Company) z;

            if (ctest.compName == this.compName && ctest.compWorkers == this.compWorkers
                   ) {
                return true;
            }

        }

        return false;
}
}