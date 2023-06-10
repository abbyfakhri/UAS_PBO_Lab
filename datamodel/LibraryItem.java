package datamodel;

public class LibraryItem {

    private String itemID;
    private String title;
    private String publisher;
    private int itemCount;

    public void borrowItem(){
        if(isAvailable() && itemCount > 0){
            System.out.println(title+ " added to your borrow list");
            itemCount--;
        }
        else{
            System.out.println(title+" is not available at this moment");
        }

    }

    public void returnItem(){
        if(!isAvailable()){
            System.out.print("thank you for returning "+ title);
            itemCount++;
        }
        else{
            System.out.println(title+" is not available at this moment");
        }
    }

    public boolean isAvailable(){
        boolean status = true;

        if(itemCount <= 0){
            status = false;
        }

        return status;
    }

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
    
    
    
}
