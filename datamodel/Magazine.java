package datamodel;

public class Magazine extends LibraryItem{
    private String issueNumber;
    private boolean isMonthly;
    private String category = "magazine";

    public String getIssueNumber(){
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber){
        this.issueNumber = issueNumber;
    }

    public boolean getIsMonthly(){
        return isMonthly;
    }

    public void setIsMonthly(boolean isMonthly){
        this.isMonthly = isMonthly;
    }

    public String getCategory(){
        return category;
    }



}
