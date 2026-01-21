class Classes {
    int id;
    String n;

    public Classes(int id, String n) {
        this.id = id;
        this.n = n;
    }
    public static void main(String[] args){

        Classes new_obj = new Classes(10,"Rahul Goel");
        System.out.println("ID : "+new_obj.id+"\nName : "+new_obj.n);
    }
}