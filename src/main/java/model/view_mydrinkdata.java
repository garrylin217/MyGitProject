package model;

public class view_mydrinkdata {
    private Integer myDrinkParentid;  //父分類名稱 id
    private String myDrinkParentName;  //父分類名稱
    private String myDrinkParentDescription; //父分類描述
    private String myDrinkParentCategory;  // 父分類種類
    private Integer drinkId;   //飲料id
    private String drinkName; //飲料名稱
    private Integer drinkPrice; //飲料單價
    private String drinkDescription; //飲料描述
    private String drinkCategory; //飲料種類

    public view_mydrinkdata() {}

    public view_mydrinkdata(Integer myDrinkParentid, String myDrinkParentName, String myDrinkParentDescription,
            String myDrinkParentCategory, Integer drinkId, String drinkName, Integer drinkPrice,
            String drinkDescription, String drinkCategory) {
  
        this.myDrinkParentid = myDrinkParentid;
        this.myDrinkParentName = myDrinkParentName;
        this.myDrinkParentDescription = myDrinkParentDescription;
        this.myDrinkParentCategory = myDrinkParentCategory;
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkDescription = drinkDescription;
        this.drinkCategory = drinkCategory;
        
    }

    // Getters and Setters
    public Integer getMyDrinkParentid() {
        return myDrinkParentid;
    }

    public void setMyDrinkParentid(Integer myDrinkParentid) {
        this.myDrinkParentid = myDrinkParentid;
    }

    public String getMyDrinkParentName() {
        return myDrinkParentName;
    }

    public void setMyDrinkParentName(String myDrinkParentName) {
        this.myDrinkParentName = myDrinkParentName;
    }

    public String getMyDrinkParentDescription() {
        return myDrinkParentDescription;
    }

    public void setMyDrinkParentDescription(String myDrinkParentDescription) {
        this.myDrinkParentDescription = myDrinkParentDescription;
    }

    public String getMyDrinkParentCategory() {
        return myDrinkParentCategory;
    }

    public void setMyDrinkParentCategory(String myDrinkParentCategory) {
        this.myDrinkParentCategory = myDrinkParentCategory;
    }

    public Integer getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Integer drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Integer getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(Integer drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public String getDrinkCategory() {
        return drinkCategory;
    }

    public void setDrinkCategory(String drinkCategory) {
        this.drinkCategory = drinkCategory;
    }

    public String show() {
        return this.myDrinkParentid + "\n" +
               this.myDrinkParentName + "\n" +
               this.myDrinkParentDescription + "\n";
    }
}
