public class Employee {

    private String name;
    private String jobTitle;
    private String org;
    private int bDate;

    public Employee(String employeeName, String employeeJobTitle, String organization, int birthDay) {
        this.name = employeeName;
        this.jobTitle = employeeJobTitle;
        this.org = organization;
        this.bDate = birthDay;
    }


    public Employee() {
        name = "No Name";
        jobTitle = "N/A";
        org = "N/A";
        bDate = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getbDate() {
        return bDate;
    }

    public void setbDate(int bDate) {
        this.bDate = bDate;
    }


    public boolean equals(Employee t) {
        if (this == t) {
            return true;
        }

        if (t == null) {
            return false;
        }
        if (t instanceof Employee) {
            Employee test = (Employee) t;

            if (test.name == this.name && test.jobTitle == jobTitle
                    && test.org == org && test.bDate == bDate) {
        return true;
    }

}

        return false;
                }



}


