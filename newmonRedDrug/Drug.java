package javaa.RPG.newmonRedDrug;

public class Drug {
    private String Size;
    private int Add;

    Drug(String size, int add) {
        Size = size;
        Add = add;
    }

    Drug() {

    }

    public void setSize(String size) {
        Size = size;
    }

    public void setAdd(int addLife) {
        Add = addLife;
    }

    public int getAdd() {
        return Add;
    }

    public String getSize() {
        return Size;
    }

}
