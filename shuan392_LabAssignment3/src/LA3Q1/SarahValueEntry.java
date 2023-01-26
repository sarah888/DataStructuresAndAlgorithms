package LA3Q1;

public class SarahValueEntry {
    private Integer key;

    public SarahValueEntry(){
        key = -1; //should be hash
    }

    public SarahValueEntry(Integer num){
        key = num;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
