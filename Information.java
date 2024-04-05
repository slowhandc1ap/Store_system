public class Information {
    static String password = "admin";
    private String name ;

    private String surename ;
    int id = 0000 ;
    
    public Information(){

    }

    public void setName(String name){
        this.name = name;
    }
    public void setSureName(String lastname){
        this.surename = lastname;
    }
    public void setID(int id){
        this.id += id+1 ;     
    }

    public String getName() {
        return name;
    }
    public String getSurename() {
        return surename;
    }
    public int getID() {
        return id;
    }

    
    
    
    public String toString() {
        return  getName() + " "+ getSurename();


    }
}
