package datamodel;

public class LibraryItem {

    private String itemID;
    private String title;
    private boolean available;
    private String publisher;
    private int itemCount;

    public void setItemCount(int itemCount){
        this.itemCount = itemCount;
    }

    public int getItemCount(){
        return itemCount;
    }

    public String getItemID(){
        return itemID;
    }

    public void setItemID(String itemID){
        this.itemID = itemID;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }
    
    public void borrowItem(){
        if(available && itemCount > 0){
            System.out.println(title+ " added to your borrow list");
            available = false;
            itemCount--;
        }
        else{
            System.out.println(title+" is not available at this moment");
        }

    }

    public void returnItem(){
        if(!available){
            available = false;
        }
        else{
            System.out.println(title+" is not available at this moment");
        }
    }
    
}
